package GUI2.cw1;

public class Test {

    public static void main(String[] args) {

        Pacjent[] pacjenci = { new ChoryNaGlowe("Janek"),
                new ChoryNaNoge("Edzio"),
                new ChoryNaDyspepsje("Marian")
        };

        for (Pacjent p : pacjenci) {
            System.out.println("Pacjent:     " + p.nazwisko() + '\n' +
                    "Chory na:    " + p.choroba() + '\n' +
                    "Zastosowano: " + p.leczenie() +"\n\n"
            );
        }

    }

}