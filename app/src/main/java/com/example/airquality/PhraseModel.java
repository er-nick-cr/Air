package com.example.airquality;

public class PhraseModel {
    private final String bad_v1 = "Ебать чернобыль, ты чего там забыл? Я бы на твоем месте просто из дома не выходил в этот сектор газа. Третья рука еще не выросла?";
    private final String bad_v2 = "Короче без лишних слов, с тобой тут поговорить хотят: https://www.youtube.com/watch?v=H2xwlnosyog";
    private final String bad_v3 = "Я бы на твоем месте курить начал прямо ейчас, потому что по сравнению с тем, чем ты дышишь, сигаретный дым намного чище";
    private final String bad_v4 = "Все нормально, все хорошо, сейчас будем задыхаться, братишка";

    private final String[] bad = new String[] {bad_v1, bad_v2, bad_v3, bad_v4};

    private final String middle_v1 = "Дышать, конечно, можно, но душновато. Так же душновато, как и твоя манера говорить";
    private final String middle_v2 = "Че грязноватый воздух? Так хуячь в деревню, хозяйство поднимай! Развелось програмистов в стране, поля стоят не паханые";
    private final String middle_v3 = "Дышать можно, но очень осторожно.";
    private final String middle_v4 = "Мда, вот у меня когда дед жил, такого не было. Воздухом тогда раны лечили, на улицу вышел сразу третье легкое вырастало";

    private final String[] middle = new String[] {middle_v1, middle_v2, middle_v3, middle_v4};

    private final String good_v1 = "Ля, чи шо альпийская деревня? Откуда такой чистый воздух, небось заграница какая";
    private final String good_v2 = "Кислорода столько, что если зажешь спичку, то все вокруг просто рванет, так что бросай курить и свою токсичную бабу";
    private final String good_v3 = "Есть кислородное голодание, а у тебя сейчас кислородное обжирание";
    private final String good_v4 = "Никому не рассказывай где-ты, а то понаедут со своих Красноярсков";

    private final String[] good = new String[] {good_v1, good_v2, good_v3, good_v4};

    public String getRandomBad() {
        int s = (int)Math.floor(Math.random() * bad.length);
        return bad[s];
    }

    public String getRandomMiddle() {
        int s = (int)Math.floor(Math.random() * middle.length);
        return middle[s];
    }

    public String getRandomGood() {
        int s = (int)Math.floor(Math.random() * good.length);
        return good[s];
    }
}
