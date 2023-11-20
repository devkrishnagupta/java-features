package designPatterns.facadePattern;

class Lighting {
    public void on() {
        System.out.println("Lights are on");
    }
    public void off() {
        System.out.println("Lights are off");
    }
}

class MusicSystem {
    public void playMusic() {
        System.out.println("Music is playing");
    }
    public void stopMusic() {
        System.out.println("Music is stopped");
    }
}

class ClimateControl {
    public void setTemperature(int temp) {
        System.out.println("Temperature set to " + temp + " degrees");
    }
}

class SmartHomeFacade {
    private Lighting lighting;
    private MusicSystem musicSystem;
    private ClimateControl climateControl;

    public SmartHomeFacade(Lighting lighting, MusicSystem musicSystem, ClimateControl climateControl) {
        this.lighting = lighting;
        this.musicSystem = musicSystem;
        this.climateControl = climateControl;
    }

    public void startEveningRoutine() {
        lighting.on();
        musicSystem.playMusic();
        climateControl.setTemperature(22);
    }

    public void endEveningRoutine() {
        lighting.off();
        musicSystem.stopMusic();
    }
}

public class SmartHome {
   public static void main(String[] args) {
        SmartHomeFacade smartHomeFacade = new SmartHomeFacade(new Lighting(), new MusicSystem(), new ClimateControl());
        smartHomeFacade.startEveningRoutine();
        System.out.println("-------------------------------------------");
        smartHomeFacade.endEveningRoutine();
    }
}