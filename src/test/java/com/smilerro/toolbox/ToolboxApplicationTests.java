package com.smilerro.toolbox;

import com.smilerro.toolbox.entity.Category;
import com.smilerro.toolbox.entity.Gate;
import com.smilerro.toolbox.entity.User;
import com.smilerro.toolbox.entity.WebSite;
import com.smilerro.toolbox.repository.CategoryRepository;
import com.smilerro.toolbox.repository.GateRepository;
import com.smilerro.toolbox.repository.UserRepository;
import com.smilerro.toolbox.repository.WebSiteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class ToolboxApplicationTests {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    WebSiteRepository webSiteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    GateRepository gateRepository;
    @Test
    void addWebSide() {
        String sites = "欧美剧FFCChttp://www.zimuzu.tv/=====人人影视,http://neets.cc/=====neets,http://www.meijutt.com/=====美剧天堂,http://videos.yizhansou.com/=====一站搜,http://www.tntdy2.vip/=====TNT影视,https://fantopia.club/=====翻托邦美剧,https://www.icezmz.com/=====冰冰字幕组,http://sskzmz.com/=====ssk字幕组,http://dbfansub.com/=====电波字幕组,http://www.orangesub.com/=====Orange字幕组target=\"_blank\" ,http://cili001.com/=====MAG磁力,http://www.zimuxia.cn/=====FIX字幕侠,@@韩剧FFCChttp://www.hanfan.cc/hanju/=====韩饭网,http://www.hanmi520.com/forum-8-1.html=====韩迷字幕组,https://www.hanjutv.com/=====韩剧TV,http://www.2hanju.com/=====韩剧门户,https://www.hanju55.com/=====韩剧在线,https://www.juji.tv/=====韩剧集网,http://www.hanju.cc/=====韩剧网,http://hxly9.com/forum.php=====幻想乐园,http://shenbibi.com/portal.php=====神叨字幕组,@@日剧FFCChttps://www.rijutv.com/v_all/list-catid-7.html=====日剧TV,http://www.riju.tv/=====日剧网,http://zhuixinfan.com/main.php=====追番剧,http://www.zzrbl.com/=====猪猪日剧部落,http://www.zzrbl.com/=====猪猪日剧,http://www.hideystudio.com/drama/=====隐社,http://www.mytvbt.net/forumdisplay.php?fid=6=====日菁字幕组,http://www.tokyonothot.com/portal.php=====东京不够热,@@国产剧FFCChttps://www.allcine.cn/=====奥洛林影视,http://v.sunbook.cc/=====暖光影视,https://www.kankanwu.com/=====看看屋,https://www.tvb52.com/vodtypehtml/guochanju/=====豆角网,https://www.ywtx.cc/=====一网天下,http://www.aiaike.com/=====爱爱客影院,http://www.haoju5.com/dalu/=====火剧网,http://www.kkkkmao.com/Domestic/=====4K屋,http://www.bbz520.com/list/?28.html=====波波仔影院,http://www.beiwo888.com/list/15/=====被窝,http://www.6vhao.tv/dlz/=====6V国剧,http://www.100pd.cc/cat/12.html=====100频道,https://www.xinju55.com/tv/=====新剧影视,http://www.shuajuzu.com/=====大帅影视,http://www.555tv.cn/=====555TV,http://www.gscq.me/=====乐赏剧集,@@动漫FFCChttps://www.bilibili.com/=====B站,http://www.missevan.com/=====M站,http://www.kisssub.org/=====爱恋动漫,https://mikanani.me/=====Mikan,http://www.comicat.org/=====漫猫动漫,https://bangumi.moe/=====萌番组,http://www.moonbt.com/=====月影动漫,http://www.ikanfan.com/=====爱看番动漫";
        String[] split = sites.split("@@");
        for (String gs : split) {
            String[] split1 = gs.split("FFCC");
            Category category = new Category();
            category.setName(split1[0]);
            Gate gate = new Gate();
            gate.setId("4028e0816e10231c016e102337e90001");
            category.setGate(gate);
            Category save = categoryRepository.save(category);

            String[] sitemsgs = split1[1].split(",");
            for (String msg : sitemsgs) {
                WebSite webSite = new WebSite();
                String[] split2 = msg.split("=====");
                webSite.setName(split2[1]);
                webSite.setLink(split2[0]);
                webSite.setCategory(save);
                webSiteRepository.save(webSite);
            }
        }

    }


}
