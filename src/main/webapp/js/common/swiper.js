/**
 * Created by lihua on 2017/7/14.
 */
//�ȵ��ֲ�ͼ�����ݼ������֮���ٵ�ȡ�ֲ�ͼ���ֲ�
function swiperPlaugin(){
    //��ʼ��
    var size = $(".img li").size();  //��ȡͼƬ�ĸ���
    for(var i=1;i<=size;i++){	//����ͼƬ�������Ӧ�ĵײ����ָ���
        var li="<li>"+i+"</li>";	//����li��ǩ�������뵽ҳ����
        $(".num").append(li);
    }

    //�ֶ�����ͼƬ�ֲ�
    $(".img li").eq(0).show();	//��ʾ��һ��ͼƬ
    $(".num li").eq(0).addClass("active");	//��һ��ͼƬ�ײ����Ӧ�������б����active��
    $(".num li").mouseover(function(){
        $(this).addClass("active").siblings().removeClass("active");  //������ĸ��������Ǹ��������classΪactive
        var index=$(this).index();  //����ײ���������ֵ
        i=index;  //�ײ���������ֵ����ͼƬ����ֵ
        $(".img li").eq(index).stop().fadeIn(500).siblings().stop().fadeOut(500);	//����ƶ�������������ʾ��Ӧ��ͼƬ
    });

    //�Զ�����ͼƬ�ֲ�
    var i=0;  //��ʼi=0
    var t = setInterval(moves, 5000);  //���ö�ʱ����1.5���л���һվ�ֲ�ͼ

    //�Զ��л�����
    function moves() {
        i++;
        if (i == size) {
            i = 0;  //����������һ��ͼƬ�ٰ����ҵİ�ť���л�����һ��ͼ
        }
        $(".num li").eq(i).addClass("active").siblings().removeClass("active");  //��Ӧ�ײ�������ӱ���
        $(".img li").eq(i).fadeIn(5000).siblings().fadeOut(5000);  //��ӦͼƬ�л�
    }


    //�����л�����
    function moveL(){
        i--;
        if(i==-1){
            i=size-1;  //������ǵ�һ��ͼƬ�ٰ�����İ�ť���л������һ��ͼ
        }
        $(".num li").eq(i).addClass("active").siblings().removeClass("active");  //��Ӧ�ײ�������ӱ���
        $(".img li").eq(i).fadeIn(500).siblings().fadeOut(500);  //��ӦͼƬ�л�
    }
    //�����л�����
    function move(){
        i++;
        if(i==size){
            i=0;  //����������һ��ͼƬ�ٰ����ҵİ�ť���л�����һ��ͼ
        }
        $(".num li").eq(i).addClass("active").siblings().removeClass("active");  //��Ӧ�ײ�������ӱ���
        $(".img li").eq(i).fadeIn(500).siblings().fadeOut(500);  //��ӦͼƬ�л�
    }
    //��ť����¼�
    $(".swiper .left").click(function(){
        moveL();	//���������������л�����
    });
    //�Ұ�ť����¼�
    $(".swiper .right").click(function(){
        move();    //����Ҽ����������л�����
    });
    //��ʱ����ʼ�����
    $(".swiper").hover(function(){
        clearInterval(t);	//�������ֲ�������ʱ�������ʱ��
    },function(){
        t=setInterval(move,5000);  //����ƿ�ʱ��ʱ������
    })
}
//$(function(){
//
//})