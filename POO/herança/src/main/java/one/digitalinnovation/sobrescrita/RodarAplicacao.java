package one.digitalinnovation.sobrescrita;

public class RodarAplicacao {
    public static void main(String[] args) {
        ClassMae [] classes = new ClassMae[] {new ClasseFilha1(),new ClasseFilha2(), new ClassMae()};
         //polimorfismo porque estamos trabalhando com o tipo da classe mãe
        for(ClassMae classe : classes) {
            classe.metodo1();
        }

        System.out.println("");

        for(ClassMae classe : classes) {
            classe.metodo2();
        }

        System.out.println("");
                //Sobreescrita pura(quando se trabalha diretamente com o tipo da classe filha
        ClasseFilha2 classeFilha2 = new ClasseFilha2();
        classeFilha2.metodo2();
    }



}
