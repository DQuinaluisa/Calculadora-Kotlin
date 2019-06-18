import java.awt.*;
import javax.swing.*;

public class calculadora extends JFrame {

    private JTextField visor;

    public calculadora(){
        super("Calculadora");
        this.setSize(220, 220);
        JButton [] btNums = new JButton[10];
        for (byte i=0; i < btNums.length; i++) {
            final byte c = i;
            btNums[i] = new JButton(""+i);
            btNums[i].addActionListener(
                    actionEvent ->
                            visor.setText(KtCalculadoraKt.mostrar(c))
            );
        }
        JButton [] btAcoes = new JButton[6];
        final char [] acoes = {'+', '-', 'X', '=', 'C', '/'};
        for (int i = 0; i < btAcoes.length; i++){
            final char c = acoes[i];
            btAcoes [i] = new JButton(""+c);
            btAcoes [i].addActionListener(
                    actionEvent ->
                            visor.setText(KtCalculadoraKt.calcular(c))
            );
        }
        JPanel pnCentral = new JPanel();
        pnCentral.setLayout(new GridLayout(4, 4));
        final byte [][] num = {
                {7,8,9,0,4,5,6,1,1,2,3,2,0,3,4,5},
                {0,0,0,1,0,0,0,1,0,0,0,1,0,1,1,1}
        };
        for (int i = 0; i < num[0].length; i++){
            if (num[1][i]==0){
                pnCentral.add(btNums[num[0][i]]);
            }else{
                pnCentral.add(btAcoes[num[0][i]]);
            }
        }
        Font font1 = new Font("SanSerif", Font.BOLD, 20);
        visor = new JTextField("0.0");
        visor.setFont(font1);
        visor.setHorizontalAlignment(JTextField.RIGHT);
        visor.setEnabled(false);
        visor.setDisabledTextColor(Color.DARK_GRAY);

        this.add(pnCentral);
        this.add(visor, BorderLayout.NORTH);
        this.setVisible(true);
    }
}
