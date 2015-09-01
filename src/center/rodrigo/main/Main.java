package center.rodrigo.main;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) {

        try {
            
            Robot robo = new Robot();
            BufferedImage bufferedImage;
            
            System.out.println("Capturando parte da tela...");
            robo.delay(3000);
            bufferedImage = robo.createScreenCapture(new Rectangle(800, 600));
            
            System.out.println("Salvando...");
            robo.delay(3000);
            ImageIO.write(bufferedImage, "PNG", new File("print.png"));
            
            System.out.println("Pressionando a tecla Enter...");
            robo.delay(3000);
            robo.keyPress(KeyEvent.VK_ENTER);
            robo.keyRelease(KeyEvent.VK_ENTER);
            
            System.out.println("Esperando 5 segundos...");
            robo.delay(5000);
            
            System.out.println("Movendo o mouse...");
            for (int i = 0; i < 600; i++) {
                robo.mouseMove(i, i);
                robo.delay(10);
            }
            
            System.out.println("Clicando com o mouse...");
            robo.delay(3000);
            robo.mousePress(InputEvent.BUTTON1_MASK);
            robo.mouseRelease(InputEvent.BUTTON1_MASK);
            
            System.out.println("Capturando cor do pixel onde o mouse esta...");
            robo.delay(3000);
            Color cor = robo.getPixelColor((int)MouseInfo.getPointerInfo().getLocation().getX(), 
                    (int)MouseInfo.getPointerInfo().getLocation().getY());
            System.out.println(cor);
            
            System.out.println("Rolando o scrool para cima...");
            robo.delay(3000);
            robo.mouseWheel(-20);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
