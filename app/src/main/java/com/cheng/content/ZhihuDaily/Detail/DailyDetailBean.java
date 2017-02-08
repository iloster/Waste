package com.cheng.content.ZhihuDaily.Detail;

import java.util.List;

/**
 * Created by dev on 2017/1/9.
 */

public class DailyDetailBean {

    /**
     * body : <div class="main-wrap content-wrap">
     <div class="headline">

     <div class="img-place-holder"></div>



     </div>

     <div class="content-inner">




     <div class="question">
     <h2 class="question-title"></h2>

     <div class="answer">

     <div class="meta">
     <img class="avatar" src="http://pic3.zhimg.com/91e6b386ed8544c08d9c5dc42ccd652a_is.jpg">
     <span class="author">匡世珉，</span><span class="bio">和人类的感情破裂</span>
     </div>

     <div class="content">
     <p>由于要让 5 岁小孩子听懂，所以解释时不可避免地会<strong>为了保证可读性而降低严谨性</strong>。想严谨地学习选择公理的知识可以阅读<strong>公理化集合论</strong>的教材，我也会在最后放上一些扩展阅读的链接。</p>
     <p>开始咯！</p>
     <p>选择公理有很多种表述形式和等价命题，一言以蔽之：</p>
     <blockquote>对于所有的<strong>集族</strong>，均存在<strong>选择函数</strong>。</blockquote>
     <p>所谓集族，就是由非空集合构成的集合；而选择函数，就是一个定义在集族上的函数&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=f" alt="" />&nbsp;&mdash;&mdash;对于集族里的集合&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=s" alt="" />&nbsp;，&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=f%28s%29%5Cin+s" alt="" />&nbsp;. 小朋友懂了吗？</p>
     <p>（感觉要被打&hellip;&hellip;似乎只有 5 岁的陶哲轩才可以看懂&hellip;&hellip;）</p>
     <p>好吧好吧，我这么说，选择公理的意思是：</p>
     <blockquote>如果有一堆<strong>非空集合</strong>，那么我们可以从<strong>每个集合</strong>里各取出<strong>一个元素</strong>。</blockquote>
     <p>是的，就是这样。（不开玩笑地说，上面这句话应该高中生就能看懂了吧？）</p>
     <p><img class="content-image" src="http://pic1.zhimg.com/70/d2511fefec1aef734f350af5f7fcc394_b.jpg" alt="" /></p>
     <p>如上图，左边的&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=S_i" alt="" />&nbsp;表示了一堆非空集合，然后选择公理说，我们可以从每个非空集合里选出一个元素，<img class="content-image" src="http://www.zhihu.com/equation?tex=X_i" alt="" />&nbsp;就是一个例子。</p>
     <blockquote>什么叫『集合』啊？</blockquote>
     <p>额，5 岁小朋友还在上幼儿园，并不知道集合是啥&hellip;&hellip;那我接下来的话就真的是对幼儿园小朋友说的了：</p>
     <p>阿尔法幼儿园里小班、中班、大班各有 3 个，所以总共有 9 个班。下个月市里要举办一场幼儿园之间的跑步比赛，阿尔法幼儿园决定<strong>从每个班里选出一个小朋友</strong>，组成一支 9 个人的代表队，代表学校参赛。这支队伍能选出来吗？</p>
     <blockquote>当然能咯！</blockquote>
     <p>没错，而且选择方法有很多。最简单的方法就是：</p>
     <blockquote><strong>方法一：让一个体育老师到每个班上随便选一个同学，组成一支队伍。</strong></blockquote>
     <p>当然了，为了取得更好的成绩，我们可以用：</p>
     <blockquote><strong>方法二：每个班进行一次班内的跑步比赛，跑第一名的同学进入校代表队。</strong></blockquote>
     <p>如果没有那么在乎比赛成绩的话，其实方法一和方法二对大家都没什么区别，除了&mdash;&mdash;可怜的体育老师！</p>
     <p>采用方法一，那么体育老师需要到每个班都跑一趟；他可能会庆幸整个阿尔法幼儿园只有 9 个班。隔壁的贝塔幼儿园有 30 个班，每个班跑一趟要累死了！</p>
     <p>采用方法二，每个班则可以根据『<strong>班内跑步比赛第一名入选校队</strong>』这个<strong>规则</strong>来选出代表，不需要体育老师一个班一个班地跑啦。</p>
     <p>对于有些奇怪的幼儿园来说，这两种方法就不是都可以采用了，比如说街对面的伽玛幼儿园。</p>
     <p>伽玛幼儿园有&hellip;&hellip;额&hellip;&hellip;无穷多个班：1 班、2 班、3 班、4 班&hellip;&hellip;数也数不完。</p>
     <p>这个时候，方法一就不管用啦！如果让体育老师一个个跑，那么他永远也跑不完所有的班。</p>
     <p>但是方法二还是可以的，我们可以直接命令每个班根据『班内跑步比赛第一名入选校队』这个规则来选出代表。</p>
     <p>嗯！这个『<strong>班内跑步比赛第一名入选校队</strong>』的规定其实就是我之前说的『<strong>选择函数</strong>』，它能帮我们从每一个班（非空集合）里选出一个代表（元素）。<strong>选择公理就是说，对于任何一个幼儿园（集族），我们都可以找到一个规定（选择函数），让每个班按照这个规定选出一个代表（元素）。</strong></p>
     <blockquote>哦&hellip;&hellip;就是这样啊。那这不是很简单吗！</blockquote>
     <p>啊，对于跑步比赛来说是很简单。不过&hellip;&hellip;你还记得上个月市里的『先进宝宝』的评选活动吗？当时可就出了事儿了：</p>
     <p>由于『先进宝宝』没有一个可量化的具体标准，孩子们争吵得不可开交，甚至有些家长都跑到幼儿园里闹。最后，阿尔法幼儿园决定，干脆让体育老师<strong>到每个班上随便选一个小朋友</strong>进校队好了。反正这个评选活动也挺莫名其妙的。</p>
     <p>而伽玛幼儿园这下就不好办了&hellip;&hellip;无穷多个班，怎么办？于是他们最终还是决定用老方法：『<strong>班内跑步比赛第一名入选校队</strong>』。</p>
     <blockquote>啊，似乎『班内跑步比赛第一名入选校队』是一个万能方法啊！如果想不到什么好的选举方案，这个方法总是可以用。</blockquote>
     <p>没错，对于幼儿园来说是这样。可是如果每个班不是一群小朋友呢？而是一群芭比娃娃或者一群乐高小人怎么办？没办法进行跑步比赛，那如何制定一个从每个班里选出一个代表的<strong>规则</strong>呢？</p>
     <blockquote>额&hellip;&hellip;</blockquote>
     <p>在数学里我们就会遇到这样的问题。数学家所说的『<strong>集合</strong>』就相当于幼儿园的班，只不过集合里的元素不一定是<strong>小朋友</strong>，也可能就是<strong>芭比娃娃</strong>或<strong>乐高小人</strong>，也可以是<strong>数字</strong>，或是<strong>一堆三角形</strong>。而这时候我们就不能使用『班内跑步比赛第一名入选校队』的方法来从每个集合里选一个元素出来了&hellip;&hellip;</p>
     <p>然而，数学家有时候需要在每个集合里挑一个元素出来。由于不知道怎么制定规则（选择函数），他们干脆制定了『<strong>选择公理</strong>』：不管怎么着，反正总能从每个非空集合里选出一个元素！</p>
     <blockquote>这不是废话么？为什么一定要找一个所谓的『选择函数』呢？非空集合就是至少有一个元素的集合，那直接从每一个非空集合里随便选一个元素出来不就好了！数学家真是无聊= =</blockquote>
     <p>是啊，我们是可以从每个非空集合里直接选一个元素出来&mdash;&mdash;当集合的数量是<strong>有限</strong>的时候。如果集合有无穷多，我们一个集合一个集合地选，永远也选不完啊。还记得伽玛幼儿园的情况吗？</p>
     <blockquote>我真是搞不懂你们数学家！每个非空集合里都有元素存在，那<strong>随便选</strong>一个不就行了吗？不用体育老师一个个选，直接规定『每个班<strong>随便选</strong>一个代表』不就好了！</blockquote>
     <p>额，数学家是一群极其严谨的人&hellip;&hellip;你说『<strong>随便选</strong>』，他们是听不懂的&hellip;&hellip;怎么随便选？掷骰子？每个班几个人就用几个面的骰子？好吧，那我告诉你，伽玛幼儿园不仅有无穷多个班，而且每个班里都有无穷多的小朋友&hellip;&hellip;</p>
     <p>其实还有很多例子，你现在还在上幼儿园，可能不一定能听懂。不过我先写出来，等你上了中学应该就能听懂啦～</p>
     <p>例子一：</p>
     <p>正整数集合是&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=%5Cleft%5C%7B+1%2C2%2C3%2C...+%5Cright%5C%7D+" alt="" />，现在我们考虑一堆（可能无穷多个）<strong>正整数集合的非空子集</strong>。</p>
     <p>这个时候我们希望从每个非空子集中选一个元素出来，怎么办呢？</p>
     <p>很简单，我们选出<strong>每个子集内最小的那个数</strong>！也就是说，选择函数&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=f%28s%29" alt="" />&nbsp;定义为&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=s" alt="" />&nbsp;中最小的数。</p>
     <p>例子二：</p>
     <p>考虑<strong>实数轴上所有有限长度（大于零）的闭区间</strong>，这些区间就是一堆非空集合。那么怎么从每个区间里取一个元素出来呢？</p>
     <p>啊，我们可以把&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=f%28s%29" alt="" />&nbsp;定义为&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=s" alt="" />&nbsp;的<strong>中点</strong>！</p>
     <p>例子三：</p>
     <p>考虑<strong>实数的所有非空子集</strong>。这下怎么从每个非空子集中选一个元素呢&hellip;&hellip;</p>
     <p>想想看？&hellip;&hellip;</p>
     <p>&hellip;&hellip;</p>
     <p>目前为止，没有人能找到一个恰当的&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=f%28s%29" alt="" />&nbsp;作为选择函数。并且，模型论(model theory)中有一些颇具说服力的论证表明，这样的&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=f%28s%29" alt="" />&nbsp;是<strong>不可能找到</strong>的。</p>
     <p>（当然了，如果要详细论证这一点，那先得<strong>定义什么叫『找到』</strong>&hellip;&hellip;）</p>
     <p>所以，选择公理令人纠结的地方在于，『<strong>选择</strong>』和『<strong>存在</strong>』到底是什么关系。一个东西『存在』，我们就可以『选择』它吗？</p>
     <p><strong>接受了选择公理，就意味着我们假定了选择函数&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=f%28s%29" alt="" />&nbsp;始终存在，即使我们没有办法给出任何具体的构造和例子。</strong></p>
     <p>（感兴趣的话可以看看 Vanderbilt 的数学教授 Eric Schechter 的文章：<a href="http://link.zhihu.com/?target=http%3A//www.math.vanderbilt.edu/%7Eschectex/papers/difficult.pdf">Constructivism Is Difficult</a>）</p>
     <p>跟现实世界不同，数学里所有的东西都是『形式化的』，即使是像『42』这样的数字也是：你可以拿来 42 个苹果，或者召集 42 个小伙伴，但现实生活中没有『42』这个东西。</p>
     <p>所以，我们有很多『<strong>数学世界</strong>』，每一个世界都有不同的规则，我们把这些规则称为『<strong>公理</strong>』。只要这些公理不会导致矛盾，那么无论公理有多么奇怪都是可以的。</p>
     <p><strong>哥德尔和寇恩证明了，无论接受选择公理与否，都不会导致矛盾，只是身处不同的『数学世界』而已。</strong></p>
     <p>不过，除了一些研究集合论的数学家和逻辑学家以外，大部分数学家都选择接受选择公理，因为在含有选择公理的数学世界里，事情会简单一些。</p>
     <p><strong>罗素</strong>在他的《数理哲学导论》里吐槽过（不是原话，但意思一样）：</p>
     <blockquote>To choose one sock from each of infinitely many pairs of socks requires the Axiom of Choice, but for shoes the Axiom is not needed.<br /><br />（如果有无穷多双袜子，那么从每一双里选出一只需要用到选择公理；而如果是鞋子则不需要。）</blockquote>
     <p>这是因为袜子是<strong>不分左右的</strong>（不要较真，理解罗素的意思就行），所以我们没有办法规定选哪一只。而鞋子是分左右的，所以我们可以直接给出选择函数：『选左脚的鞋子！』</p>
     <p>为什么罗素要强调『<strong>无穷多双袜子</strong>』呢？因为如果是有限双袜子，我们就可以『一只一只地选』，就像之前幼儿园例子中的『方法一』一样。</p>
     <p><img class="content-image" src="http://pic1.zhimg.com/70/a10c42ae7ec41ced9acf9e14e1bc7a0c_b.jpg" alt="" /></p>
     <p>UIC 的数学教授 Jerry Bona 调侃过：</p>
     <blockquote>The Axiom of Choice is obviously true; the Well Ordering Principle is obviously false; and who can tell about Zorn's Lemma?<br /><br />（选择公理显然是对的嘛！良序原理显然是错的嘛！佐恩引理是对还是错来着？）</blockquote>
     <p>这是个玩笑话，因为这三个命题都是等价的。不过选择公理看起来确实『显然正确』，良序原理看起来确实『不那么靠谱』&hellip;&hellip;不过直觉常常与数学真理相悖，所以有这样的感觉也是正常的。</p>
     <p>好吧，讲了这么多啦，小朋友你还有什么问题吗&hellip;&hellip;？</p>
     <blockquote>好烦哦！数学家真是小题大做，为了这么个小小的选择公理都要纠结半天！</blockquote>
     <p>额，选择公理可不『小』！在数学上，如果接受了一个公理，那么从这个公理推出的所有定理都必须被接受。选择公理看起来很显然，但从中可以推出极其反常识的东西，比如著名的<strong>巴拿赫 - 塔斯基悖论(Banach-Tarski paradox)</strong>：</p>
     <blockquote>一个球可以被分成五份，接着拼成两个与原来一样大的球。</blockquote>
     <p>没错，并不是两个球的总体积跟原来一样大，而是<strong>每个球</strong>都跟原来一样大。</p>
     <p><img class="content-image" src="http://pic3.zhimg.com/70/ec633b6d5216132aca6017e3f5163d12_b.jpg" alt="" /></p>
     <p>嗯，是的，如果承认了选择公理，那么这个命题确实可以从它<strong>一步一步严谨地推导出来</strong>。</p>
     <p><img class="content-image" src="http://pic3.zhimg.com/70/1b376e712a670bab828e98fb1b3327aa_b.jpg" alt="" /></p>
     <p>别气馁，连数学家也觉得这个反直觉呢，所以才把它称为『悖论』。不过，尽管称其为『悖论』，数学家还是得接受它，因为这确确实实可以从选择公理推导出来。</p>
     <p>YouTube 上有关于这个悖论的具体的科普：<a href="http://link.zhihu.com/?target=https%3A//www.youtube.com/watch%3Fv%3Ds86-Z-CbaHA">The Banach-Tarski Paradox</a></p>
     <p>国内的小伙伴可以戳这里：<a href="http://link.zhihu.com/?target=http%3A//www.bilibili.com/video/av2801710/">【中字】分球怪论 The Banach-Tarski Paradox</a></p>
     <blockquote>等等，那这不是违反了<strong>物质守恒</strong>？球的<strong>密度</strong>不变，<strong>体积</strong>变成了之前的两倍，那<strong>质量</strong>不也凭空翻了倍？</blockquote>
     <p>这个问题问得好&hellip;&hellip;可是你怎么定义『<strong>体积</strong>』？分球的过程牵涉到一些『<strong>体积不可定义</strong>』的部分&hellip;&hellip;额，总之，选择公理的水很深，数学的水很深。如果真的想把这些都弄清楚，需要学习<strong>公理化集合论</strong>。小朋友等你长大了以后可以来学呦=w=</p>
     <p>诶，等等，小朋友，你竟然已经知道了物质守恒！</p>
     <p>&hellip;&hellip;</p>
     <p>好了不开玩笑了=w= 我就讲到这里吧！</p>
     <p>参考资料 / 扩展阅读：</p>
     <p>Wikipedia：<a href="http://link.zhihu.com/?target=https%3A//en.wikipedia.org/wiki/Axiom_of_choice">Axiom of choice</a></p>
     <p>关于选择公理的 FAQ：<a href="http://link.zhihu.com/?target=https%3A//cs.uwaterloo.ca/%7Ealopez-o/math-faq/node69.html">Relevance of the Axiom of Choice</a></p>
     <p>分析及其基础的自学手册：<a href="http://link.zhihu.com/?target=http%3A//www.math.vanderbilt.edu/%7Eschectex/ccc/index.html">Handbook of Analysis and its Foundations</a></p>
     <p>广义黎曼积分的介绍：<a href="http://link.zhihu.com/?target=http%3A//www.math.vanderbilt.edu/%7Eschectex/ccc/gauge/">An Introduction to the Gauge Integral</a></p>
     <p>Eric Schechter 教授写的关于选择公理的科普：<a href="http://link.zhihu.com/?target=http%3A//www.math.vanderbilt.edu/%7Eschectex/ccc/choice.html">Axiom of Choice</a></p>
     <p>那么就这样=w=</p>
     </div>
     </div>


     <div class="view-more"><a href="http://www.zhihu.com/question/49733073">查看知乎讨论<span class="js-question-holder"></span></a></div>

     </div>


     </div>
     </div>
     * image_source : Public Domain
     * title : 如何让一个 5 岁小孩听懂什么是选择公理？
     * image : http://pic2.zhimg.com/6c4405ddec17aeefff866e5c9a287651.jpg
     * share_url : http://daily.zhihu.com/story/9134245
     * js : []
     * ga_prefix : 010911
     * images : ["http://pic2.zhimg.com/d69091d5a0e636e5afc77ab5384f5929.jpg"]
     * type : 0
     * id : 9134245
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     */

    private String body;
    private String image_source;
    private String title;
    private String image;
    private String share_url;
    private String ga_prefix;
    private int type;
    private int id;
    private List<?> js;
    private List<String> images;
    private List<String> css;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
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

    public List<?> getJs() {
        return js;
    }

    public void setJs(List<?> js) {
        this.js = js;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }
}
