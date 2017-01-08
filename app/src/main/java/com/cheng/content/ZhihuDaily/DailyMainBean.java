package com.cheng.content.ZhihuDaily;

import java.util.List;

/**
 * Created by cheng on 2017/1/8.
 */

public class DailyMainBean {

    /**
     * date : 20170108
     * stories : [{"images":["http://pic1.zhimg.com/9a3adf9e59dd5d958fe0a5afb8529294.jpg"],"type":0,"id":9132747,"ga_prefix":"010821","title":"这个生化系魔法少女，和那些小公举不太一样"},{"images":["http://pic1.zhimg.com/5b88cf02d86271658fe4f438ff9f3440.jpg"],"type":0,"id":9001104,"ga_prefix":"010820","title":"自带动力的智能假肢，实现的难处在哪儿？"},{"images":["http://pic4.zhimg.com/c67c97c21f2f4de6455243c8f352069f.jpg"],"type":0,"id":9133200,"ga_prefix":"010819","title":"基金经理如果真有稳定赚钱能力，为什么要帮别人赚钱？"},{"images":["http://pic3.zhimg.com/6a9f766e54f03192c66cf861120cd1c2.jpg"],"type":0,"id":9132052,"ga_prefix":"010818","title":"做过咨询与投资，这是我快速了解一个行业的方法"},{"images":["http://pic3.zhimg.com/a905528dadd11e3b04ac5e62ad8b41c6.jpg"],"type":0,"id":9133712,"ga_prefix":"010817","title":"知乎好问题 · 哪些地方适合一个人旅行？"},{"images":["http://pic4.zhimg.com/879346919c83c38a1d8ce7380c45eeff.jpg"],"type":0,"id":9132880,"ga_prefix":"010816","title":"他知道我要往左边踢，我知道他要往左边扑，点球怎么罚？"},{"images":["http://pic3.zhimg.com/7050dfe63750d3a8451c556bc0a6a642.jpg"],"type":0,"id":9130661,"ga_prefix":"010815","title":"动物也有声带，为什么不试试教它们说话呢？"},{"images":["http://pic2.zhimg.com/4d91b606de409bad4859500526617799.jpg"],"type":0,"id":9132060,"ga_prefix":"010814","title":"高风险高收益，所以才要把鸡蛋放在不同的篮子里"},{"images":["http://pic3.zhimg.com/79b6b54e8500b1531f08cfa9aff4a866.jpg"],"type":0,"id":9130769,"ga_prefix":"010813","title":"这么多水果都号称「水果之王」，到底哪个最有营养？"},{"images":["http://pic3.zhimg.com/0fdcb95c3712dabb0519df654b63c34a.jpg"],"type":0,"id":9127853,"ga_prefix":"010812","title":"大误 · 如何用钱追姑娘？"},{"images":["http://pic4.zhimg.com/a88ec4c9ddd6740168a141ca7be5fdfb.jpg"],"type":0,"id":9128999,"ga_prefix":"010811","title":"住在主干道旁边，老年失智的风险也会提高"},{"images":["http://pic3.zhimg.com/30627df3aa7c286afc5e94a8deafe7ce.jpg"],"type":0,"id":9131937,"ga_prefix":"010810","title":"「你的情绪不重要」「你的感受是错的」"},{"images":["http://pic3.zhimg.com/d514f7d66747aa29e265c0c3987aa252.jpg"],"type":0,"id":9132006,"ga_prefix":"010809","title":"CPU 进行计算时，把电能转化成了什么能？"},{"images":["http://pic2.zhimg.com/96831eb0564f928c3500c5513b87e119.jpg"],"type":0,"id":9129134,"ga_prefix":"010808","title":"一开始人们靠关系，后来靠市场和大 V"},{"images":["http://pic2.zhimg.com/41359f9e4cc29dce3b5c6de32f1cfdc5.jpg"],"type":0,"id":9131689,"ga_prefix":"010807","title":"恶劣天气中照样安全起降，俄航真的有「战斗天赋」吗？"},{"images":["http://pic4.zhimg.com/fc4c47636e8aca6838db554b69b6d9eb.jpg"],"type":0,"id":9131792,"ga_prefix":"010807","title":"啤酒要冰镇才好喝，没冰箱的时代人们也想了好多办法"},{"images":["http://pic3.zhimg.com/d29442cd39271f80bc90f059866a2aba.jpg"],"type":0,"id":9130223,"ga_prefix":"010807","title":"人工智能会取代人类，甚至，控制人类吗？"},{"images":["http://pic4.zhimg.com/7d2ff57136a1378ac3c899675588e587.jpg"],"type":0,"id":9125897,"ga_prefix":"010806","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic2.zhimg.com/7331618708eef8c8e7a5582f774084ad.jpg","type":0,"id":9133712,"ga_prefix":"010817","title":"知乎好问题 · 哪些地方适合一个人旅行？"},{"image":"http://pic3.zhimg.com/c1d0dbd25a622158953ee3c64f85e1d2.jpg","type":0,"id":9131689,"ga_prefix":"010807","title":"恶劣天气中照样安全起降，俄航真的有「战斗天赋」吗？"},{"image":"http://pic2.zhimg.com/6c624ffa91f49dca1eeccac61d271261.jpg","type":0,"id":9130769,"ga_prefix":"010813","title":"这么多水果都号称「水果之王」，到底哪个最有营养？"},{"image":"http://pic2.zhimg.com/6875f8e6bc97774c692d1760b946f74d.jpg","type":0,"id":9130223,"ga_prefix":"010807","title":"人工智能会取代人类，甚至，控制人类吗？"},{"image":"http://pic4.zhimg.com/99d97b0e3bc20747798569b78f7384b7.jpg","type":0,"id":9131226,"ga_prefix":"010717","title":"知乎好问题 · 哪些疾病与经济条件和受教育程度相关？"}]
     */

    private String date;
    /**
     * images : ["http://pic1.zhimg.com/9a3adf9e59dd5d958fe0a5afb8529294.jpg"]
     * type : 0
     * id : 9132747
     * ga_prefix : 010821
     * title : 这个生化系魔法少女，和那些小公举不太一样
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic2.zhimg.com/7331618708eef8c8e7a5582f774084ad.jpg
     * type : 0
     * id : 9133712
     * ga_prefix : 010817
     * title : 知乎好问题 · 哪些地方适合一个人旅行？
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
