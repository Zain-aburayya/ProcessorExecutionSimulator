package components;

public class Clock {
    private static Clock instance = null;
    private Clock(){}
    public static Clock getInstance(){
        if(instance == null){
            instance = new Clock();
        }
        return instance;
    }
    int currentSecond = 1;

    int allDuration;

    public void setAllDuration(int allDuration) {
        this.allDuration = allDuration;
    }

    public int getCurrentSecond() {
        return currentSecond;
    }

    public boolean isOver(){
        return currentSecond > allDuration;
    }

    public void tick() throws InterruptedException {
        Thread.sleep(1000);
        currentSecond++;
    }

}
