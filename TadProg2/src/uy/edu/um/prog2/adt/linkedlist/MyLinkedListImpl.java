package uy.edu.um.prog2.adt.linkedlist;

public class MyLinkedListImpl <T> implements MyLinkedList<T>{
    private Nodo<T> head;
    public MyLinkedListImpl() {
        this.head=null;
    }

    @Override
    public void add(T value) {
        if(this.head==null){
            this.head= new Nodo<T>(value);
        } else {
            Nodo<T> temp=this.head;
            while (temp.getNext() != null){
                temp=temp.getNext();
            }
            Nodo<T> newNode= new Nodo(value);
            temp.setNext(newNode);
        }
    }

    @Override
    public void remove(int position) {
        if(position==0 ){
            Nodo<T> sig=this.head.getNext();
            this.head= sig;

        } else {
            int cont=0;
            Nodo<T> temp=this.head;
            while (cont<position-1){

                try {
                    temp=temp.getNext();
                } catch (NullPointerException npe) {
                    System.out.println("Fuera de rango");
                    return;
                }
                cont++;
            }
            try{
                Nodo<T> temp2=temp.getNext().getNext();
                temp.setNext(temp2);

            } catch (NullPointerException npe){
                System.out.println("Fuera de rango");
            }


        }

    }

    @Override
    public T get(int position) {
        T valor=null;
        if(this.head!=null){
            if(position==0){
                valor= this.head.getValue();
                return valor;
            } else {
                int cont=0;
                Nodo<T> temp=this.head;
                while (cont<position && temp!=null){
                    temp=temp.getNext();
                    cont++;
                }
                if(temp!=null){
                    valor = temp.getValue();
                }

                return valor;

            }

        } else{
            return null;
        }


    }

    @Override
    public int size() {
        if(this.head!=null){
            int count=0;
            Nodo<T> temp=this.head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
                count++;
            }
            return count+1;
        } else {
            return 0;
        }

    }

    public void addFirst(T value){
        if(this.head==null){
            this.head= new Nodo<T>(value);
        } else {
            Nodo temp=this.head;
            this.head=new Nodo<T>(value);
            this.head.setNext(temp);
        }
    }
    public void addLast(T value){
        add(value);
    }
}
