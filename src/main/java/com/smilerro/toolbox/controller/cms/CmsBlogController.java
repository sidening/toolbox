package com.smilerro.toolbox.controller.cms;

import com.smilerro.toolbox.controller.BaseController;
import com.smilerro.toolbox.entity.blog.Article;
import com.smilerro.toolbox.entity.blog.BlogCate;
import com.smilerro.toolbox.entity.blog.Lable;
import com.smilerro.toolbox.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/cms/blog")
public class CmsBlogController extends BaseController {

    private SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyyMM/");
    @Value("${image.uploadPath.main}")
    private String mainPicUploadPath;
    @Value("${image.getPath.main}")
    private String mainPicReadPath;
    @Autowired
    private LableRepository lableRepository;
    @Autowired
    BlogCateRepository blogCateRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping()
    public String indexPage(Model model){
        //1.获取所有分类
        List<BlogCate> blogCates = blogCateRepository.findAll();
        model.addAttribute("blogCates",blogCates);
        //2.获取所有标签
        List<Lable> lables = lableRepository.findAll();
        model.addAttribute("lables",lables);
        return "cms/sonPage/blogadd";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map save(HttpServletRequest request,
                       Article article,
                       String[] lables,
                       @RequestParam(value = "file") MultipartFile file){
        //1.存储图片
        //1.1 文件名
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffixName;
        //1.1 时间路径
        String datePath = simpleDateFormat.format(new Date());
        File dest = new File(mainPicUploadPath+datePath+fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            String picPath = mainPicReadPath+datePath+fileName;
            article.setMainPic(picPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.处理标签
        List ls = new ArrayList();
        for (String lname:lables) {
            ls.add(new Lable(lname));
        }
        List list = lableRepository.saveAll(ls);
        article.setLables(list);

        //3. 保存
        try {
            Article save = articleRepository.save(article);
            Map result = getResult(true, "保存成功");
            result.put("id",save.getId());
            return result;
        }catch (Exception e){
            Map result = getResult(false, "保存失败");
            return result;
        }
    }

    @RequestMapping("/saveLable")
    public Map saveLable(@RequestBody Lable lable){
        try{
            Lable save = lableRepository.save(lable);
            Map result = getResult(true);
            result.put("lable",save);
            return result;
        }catch (Exception e){
            return getResult(false);
        }
    }
}
