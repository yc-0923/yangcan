package cn.itcast.text;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.util.UuidUtil;

import java.util.Random;

public class UserDaoText {



    public static void main(String[] args) throws Exception {


        User user=new User();

        UserService service=new UserServiceImpl();


        Random random=new Random();


 String na[]={"李","张","吴","王","彭","冉","陈","马","吕","欧阳","金","何","尹","黄","邹","游","郑","周"};

        String ma[]={"快","抗","昆","果"
                ,"空","亟","其","具","券","卷","奇","委","季","宜","居","届","岢","岸","扬",
                "杰","佳","京","侄","佳","来","例","制","到","兔","两","典","卷","周","呢","坦",
                "奈","妮","宙","定","居","屉","帖","底","店","征","忝","忠","念","技","投","政","枝",
                "东","林","汰","决","玖","知","的","直","纠","金","两","乳","侏","佰","侗","佻","佬","具",
                "冽","卓","拈","妲","妯","宕","岱","岭","帖","帙","底","抒","林","杼","沓","炉","竺","长","依",
                "侑","味","夜","委","宜","宛","岳","岸","岩","往","亚","武","於","易","昂","旺","沅","沃","汪","物",
                "艾","卧","佯","儿","咏","抑","昀","炎","杳","事","享","侍","使","侈","然","刹","刺","协","卒","洽","沁",
                "取","受","步","垂","奇","始","炊","姓","妻","妾","尚","屈","弦","所","承","昌","升","昔","松","欣","沙","沈",
                "社","舍","炊","采","长","青","幸","亟","徇","佳","舍","儿","争","其","刷","券","制","效","卷","姐","姒","姗","季",
                "炙","宗","届","岫","征","承","昔","析","枕","状","八","并","佩","函","和","命","坡","坪","奉","孟","帛","水","府","佛",
                "彼","忽","或","戽","房","扮","枇","扶","放","昏","朋","服","明","杭","杯","枚","板","沛","沐","汾","版","牧","虎","门","阜",
                "杷","盲","非","伉","志","辉","","再","冲","刑","向","在","夙","如","宅","守","字","存","寺","式","戌","收","早","旭","旬","曲","次","此","求","系","肉","臣","自","舌","血","行","圳","西","休","交","件","企","匠","光","匡","共","各","考","交","件","价","企","伍","伎","仰","吉","圭","曲","机","艮","六","仲","吉","州","朱","兆","决","匠","地","旨","朵","吏","列","年","劣","同","打","汀","至","臼","灯","竹","老","舟","伎","吊","吏","圳","的","宅","机","老","肉","虫","伊","仰","伍","印","因","宇","安","屹","有","羊","而","耳","衣","亦","吃","夷","奸","聿","丞","企","休","任","先","全","吉","尖","而","至","色","伏","后","名","回","好","妃","帆","灰","牟","百","份","米","伐","亥","卉","冰","刑","合","向","旭","朴","系","行","汜","复"
        };
        String sex[]={"男","女"};


        String ph[]={"132","135","186","185","130","131","132","136","137","138","151","150","152","155","188","190","191"};




        for(int j=0;j<10010;j++){



            String name=na[random.nextInt(17)]+ma[random.nextInt(ma.length)];

        for(int i=0;i<random.nextInt(2);i++){

            name+=ma[random.nextInt(ma.length)];


        }






        user.setUsername(""+(int)((random.nextDouble()+random.nextInt(9)+1)*1000)+(int)((random.nextDouble()+random.nextInt(9)+1)*1000)+random.nextInt(9)+random.nextInt(10));

        user.setPassword(""+(int)((random.nextDouble()+random.nextInt(9)+1)*1000)+(int)((random.nextDouble()+random.nextInt(9)+1)*1000)+random.nextInt(9)+random.nextInt(10));

        user.setEmail(""+(int)((random.nextDouble()+random.nextInt(9)+1)*1000)+(int)((random.nextDouble()+random.nextInt(9)+1)*1000)+random.nextInt(9)+random.nextInt(10)+"@qq.com");

        user.setName(name );
        user.setSex(sex[random.nextInt(2)] );
        user.setAge( ""+(random.nextInt(60)+16));
        user.setPhone( ph[random.nextInt(ph.length)]+(int)((random.nextDouble()+random.nextInt(9)+1)*1000)+(int)((random.nextDouble()+random.nextInt(9)+1)*1000));

        System.out.println(user);
        service.regist(user);




    }     }


}
