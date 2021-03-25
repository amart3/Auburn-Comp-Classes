import java.text.DecimalFormat;
/** 
*Project4. 
*@author Lawrence Martin.
*@version 2/6/19.
*/
public class PentagonalPyramid {
/*
*tells Strings. 
* @param args Command line arguments (not used).
*/
//Instance Variables 
   private  String label = "";
   private double baseEdge = 0;
   private double height = 0;

//Constructor 
   /**
   *@param labelIn the input label.
   *@param baseEdgeIn the input edge. 
   *@param heightIn the input height. 
   */
   public PentagonalPyramid(String labelIn, double baseEdgeIn, double heightIn)
   {
      setLabel(labelIn); 
      setBaseEdge(baseEdgeIn);
      setHeight(heightIn);
   }
   //Methods 
   /** 
   *@return a string.
   */
   public String getLabel() {
   
      return label;
   }
   /**
   *@param labelIn a label
   *@return setLabel.
   */
   public boolean setLabel(String labelIn) {
      if (labelIn != null) { 
         label = labelIn.trim();
         return true; 
      }
      else {
         return false; 
      }
   }
   /** 
   *@return a double.
   */
   public double getBaseEdge() {
      
      return baseEdge;
   }
   /** 
   *@param baseEdgeIn a base. 
   *@return setbaseEdge.
   */
   public boolean setBaseEdge(double baseEdgeIn) { 
      if (baseEdgeIn > 0) {
         baseEdge = baseEdgeIn; 
         return true; 
      }
      else {
         return false; 
      }
   }
   /**
   *@return a double. 
   */
   public double getHeight() { 
   
      return height; 
   }
   /**
   *@param heightIn a height. 
   *@return setHeight.
   */
   public boolean setHeight(double heightIn) { 
      if (heightIn > 0) {
         height = heightIn; 
         return true; 
      }
     
      return false; 
      
   }
   /**
   *@return a double.
   */
   public double surfaceArea() { 
      return ((5.0 / 4.0) * Math.tan(
      Math.toRadians(54))
         * Math.pow(baseEdge, 2)) + (5 * (baseEdge / 2.0)
         * (Math.sqrt(Math.pow(height, 2) 
         + Math.pow(baseEdge * Math.tan(Math.toRadians(54)) / 2.0, 2))));
   }
   /**
   *@return a double.
   */
   public double volume() { 
      return 5.0 / 12.0 * Math.tan((54 * Math.PI) / 180)
         * height * Math.pow(baseEdge, 2);
   }
   /**
   *@return a string.
   */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0######");
     
      return "PentagonalPyramid \"" + label + "\" with"
         + " base edge = " + baseEdge + " and height = "
         + height + " units has:\n\tsurface area = " 
         + df.format(surfaceArea()) + " square units\n\tvolume = "
         + df.format(volume()) + " cubic units";
   
   }
}