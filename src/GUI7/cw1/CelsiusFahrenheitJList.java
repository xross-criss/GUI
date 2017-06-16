/**
 * Treść zadania:
 * --------------
 * <p>
 * Stworzyć JListę, pokazująca informacje o temperaaturze w postaci:
 * k stopni C = f stopni F
 * <p>
 * gdzie k zmienia się od -70 do +60.
 * <p>
 * Uwaga: nie wolno używać tablic ani kolekcji.
 */

package GUI7.cw1;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/** Okno z przelicznikiem stopni Fahrenheita na Celsiusa
 *
 *
 */
public class CelsiusFahrenheitJList extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel topPanel;
    private JList<String> listbox;


    public CelsiusFahrenheitJList() {
        setTitle("Celsius -> Fahrenheit JList");

        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        listbox = new JList<String>();
        listbox.setModel(Z51CreateListModel(-70, 60));

        topPanel.add(new JScrollPane(listbox));

    }


    /** Przygotowuje listmodel gotowy do użycia przy wyświetlaniu listy.
     *
     * @param minTemp temperatura minimalna
     * @param maxTemp temperatura maksymalna
     * @return listmodel stringów w postaci "k stopni C = f stopni F"
     */
    private DefaultListModel<String> Z51CreateListModel(double minTemp, double maxTemp) {

        DefaultListModel<String> listModel;

        listModel = new DefaultListModel<String>();

        for (int a = (int) minTemp; a <= maxTemp; a++) {
            listModel.addElement(a + " stopni C = " + String.format("%1$,.2f", CelsiusToFahrenheitConverter.convertCelsiusToFahrenheit(a)) + " stopni F");
        }

        return listModel;
    }


}
