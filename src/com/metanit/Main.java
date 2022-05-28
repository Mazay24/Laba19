package com.metanit;


import java.util.ArrayList;
import java.util.List;


interface Observable {
    void notifyObservers();
    void regObserver(Observer o);
}
interface Observer{
    void Notification(String news);
}
class Groups implements Observable{
    List<Observer> list = new ArrayList<>();
    String news;
    void setNews(String news){
        this.news = news;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for(Observer o: list){
            o.Notification(news);
        }
    }

    @Override
    public void regObserver(Observer o) {
        list.add(o);
    }
}
class USERS implements Observer{
    String name;
    public USERS(String name){
        this.name = name;
    }

    @Override
    public void Notification(String news) {
        System.out.println(name + " Получил оповещение: " + news);
    }
}
public class Main {
    public static void main(String[] args) {
        Groups RDR2 = new Groups();
        Groups CS16 = new Groups();
        Groups MEMES = new Groups();
        Groups JAVA = new Groups();

        USERS subscriber1 = new USERS("Никита Исаев Александрович");
        USERS subscriber2 = new USERS("Матвей Марусик Даниилович");
        RDR2.regObserver(subscriber1);
        RDR2.regObserver(subscriber2);
        CS16.regObserver(subscriber1);
        CS16.regObserver(subscriber2);
        MEMES.regObserver(subscriber1);
        MEMES.regObserver(subscriber2);
        JAVA.regObserver(subscriber2);

        RDR2.setNews("Рокстар услышали мольбы игроков и добавили в RDR online режим ограбления банков" + "\n");
        CS16.setNews("S1mple показал новую раскитку на карте DE_DUST!" + "\n");
        MEMES.setNews("Колобок повесился!!!" + "\n");
        JAVA.setNews("Никита Исаев сделал лабораторную работу по Патерну Наблюдатель и расчитывает получить 5!" + "\n");

    }
}
