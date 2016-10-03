/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coloso;

/**
 *
 * @author nicolasjimenez
 */
import java.util.Observer;
import java.util.Observable;


public class TextObserver implements Observer
{
   private ObservableValue ov = null;
   
   public TextObserver(ObservableValue ov)
   {
      this.ov = ov;
   }
   @Override
   public void update(Observable obs, Object obj)
   {
      if (obs == ov)
      {
         System.out.println( "value changed "+ov.getValue());
      }
   }
}