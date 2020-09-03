
package bmicalculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This simple application calculates your Body Mass Index
 * and displays whether you're at a healthy weight for your
 * height.
 * @author Keketso Mabule
 */
public class BMICalculator extends JFrame
{
    private JPanel panel;
    private JLabel weightLabel;
    private JLabel heightLabel;
    private JLabel statusLabel;
    private JTextField weightTextField;
    private JTextField heightTextField;
    private JTextField statusTextField;
    private JButton calcBMI;
    private JButton clearButton;
    
    /**
     * Constructor to build the frame
     */
    public BMICalculator()
    {
        
        JFrame window = new JFrame();             //create a JFrame object 'window'
        window.setTitle("BMI calculator");        //set the title of the window
        window.setSize(380, 200);                 //set the size of the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //the application must close whenever the user clicks the close button
        buildPanel();                             //build the panel
        window.setLayout(new GridLayout());       //set the layout of the window
        window.add(panel);                        //add the panel to the window
        window.setVisible(true);                  //display the window
    }
    
    /**
     * The <code>buildPanel()</code> method will build and
     * add the components and panel to the window
     */
    public void buildPanel()
    {
        //create the JPanel object
        panel = new JPanel();
        
        //add the height label
        heightLabel = new JLabel();
        heightLabel.setText("Enter your height in centimeters");
        heightLabel.setFont(new Font("Calibri", 10, 17));
        panel.add(heightLabel);
        
        //add the height text field
        heightTextField = new JTextField(10);
        panel.add(heightTextField);
        
        //add the weight label
        weightLabel = new JLabel();
        weightLabel.setText("Enter your weight in kilograms");
        weightLabel.setFont(new Font("Calibri", 10, 17));
        panel.add(weightLabel);
        
        //add the weight text field
        weightTextField = new JTextField(10);
        panel.add(weightTextField);
        
        //add the status label
        statusLabel = new JLabel();
        statusLabel.setText("Status (underweight, normal, overwight, or obese)");
        statusLabel.setFont(new Font("Times New Roman", 4, 17));
        panel.add(statusLabel);
        
        //add the status text field
        statusTextField = new JTextField();
        statusTextField.setPreferredSize(new Dimension(170, 25));
        statusTextField.setEditable(false);
        panel.add(statusTextField);
        
        //add the convert button
        calcBMI = new JButton();
        calcBMI.setText("Calculate BMI");
        calcBMI.setFont(new Font("Calibri", 1, 20));
        calcBMI.setPreferredSize(new Dimension(200, 30));
        calcBMI.addActionListener(new calcBMIListener());
        panel.add(calcBMI);
        
        //add the clear button
        clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setFont(new Font("Calibri", 1, 20));
        clearButton.setPreferredSize(new Dimension(150, 30));
        clearButton.addActionListener(new ClearButtonListener());
        panel.add(clearButton);
    }
    
    /**
     * This private class handles the <code>CalcBMI</code> component
     * and calculates the user's Body Mass Index.
     */
    private class calcBMIListener implements ActionListener
    {
        /**
         * The calculation happens here and displays
         * the health of the user in the <code>StatusTextField</code>.
         * @param evt 
         */
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            String weight;
            String height;
            double BMI;
            
            weight = weightTextField.getText();
            height = heightTextField.getText();
            
            BMI = Double.parseDouble(weight) / Math.pow(Double.parseDouble(height) / 100, 2);
            
            JOptionPane.showMessageDialog(null, "BMI = " + BMI);
            
            if (BMI < 18.5){                                        //if BMI is less than 18.5
                statusTextField.setText("Underweight");             //    output "Underweight"
                statusTextField.setFont(new Font("Calibri", 1, 20));
                statusTextField.setForeground(Color.BLUE);          //    set foreground color to blue
            }
            else if(BMI >= 18.5 && BMI <= 24.9){                    //else if BMI is between 18.5 and 24.9
                statusTextField.setText("Normal");                  //    output "Normal" 
                statusTextField.setFont(new Font("Calibri", 1, 20));
                statusTextField.setForeground(Color.GREEN);         //    set foreground color to green
            }
            else if (BMI >= 25.0 && BMI <= 29.9){                   //else if BMI is between 25.0 and 29.9
                statusTextField.setText("Overweight");              //    output "Overweight"
                statusTextField.setFont(new Font("Calibri", 1, 20));
                statusTextField.setForeground(Color.ORANGE);        //    set foreground color to orange
            }
            else if (BMI >= 30.0){                                  //else if BMI is greater than or equal to 30.0
                statusTextField.setText("Obese");                   //    output "Obese"
                statusTextField.setFont(new Font("Calibri", 1, 20));
                statusTextField.setForeground(Color.RED);           //    set forground color to red
            }
            else{                                                   //else
                statusTextField.setText("Undefined");               //    output "Undefined"
                statusTextField.setFont(new Font("Calibri", 1, 20));
                statusTextField.setForeground(Color.DARK_GRAY);     //    set foreground color to dark gray
            }                                                       //end if
        }
    }
    
    /**
     * This private inner class handles the <code>ClearButton</code>
     * component and clears every text field.
     */
    private class ClearButtonListener implements ActionListener
    {
        /**
         * Clears every text field in the window
         * @param evt 
         */
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            //All text fields are cleared
            weightTextField.setText("");
            heightTextField.setText("");
            statusTextField.setText("");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       BMICalculator calc = new BMICalculator();
    }
}
