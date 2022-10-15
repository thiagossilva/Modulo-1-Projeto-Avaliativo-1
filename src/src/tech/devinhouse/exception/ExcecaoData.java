package tech.devinhouse.exception;

public class ExcecaoData extends Exception{
    public void DataForaDoIntervalo(String msg) {
        System.out.println("Data inserida de forma incorreta" + msg);
    }

}
