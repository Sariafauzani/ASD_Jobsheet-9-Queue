package Tugas;

public class Queue {
    Pasien26[] antrian;
    int front;
    int rear;
    int size;
    int max;

    public Queue(int n){
        max = n;
        antrian = new Pasien26[max];
        size = 0;
        front = rear = -1;
    }
    
    public boolean IsEmpty(){
        if (size == 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull(){
        if (size == max){
            return true;
        } else {
            return false;
        }
    }

    public void peek(){
        if (!IsEmpty()){
            System.out.println("Antrian pasien terdepan: " + antrian[front].nama + " " + antrian[front].noID + " "
            + antrian[front].jenisKelamin + " " + antrian[front].umur);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print(){
        if (IsEmpty()){
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear){
                System.out.println(antrian[i].nama + " " + antrian[i].noID + " "
                 + antrian[i].jenisKelamin + " " + antrian[i].umur);
                i = (i + 1) % max;
            }
            System.out.println(antrian[i].nama + " " + antrian[i].noID + " "
            + antrian[i].jenisKelamin + " " + antrian[i].umur);
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void Enqueue(Pasien26 dt){
        if (IsFull()){
            System.out.println("Queue sudah penuh");
        } else {
            if (IsEmpty()){
                front = rear = 0;
            } else {
                if (rear == max - 1){
                    rear = 0;
                } else {
                    rear++;
                }
            }
            antrian[rear] = dt;
            size++;
        }
    }

    public Pasien26 Dequeue(){
        Pasien26 dt = new Pasien26();
        if (IsEmpty()){
            System.out.println("Queue masih kosong");
        } else {
            dt = antrian[front];
            size--;
            if (IsEmpty()){
                front = rear = -1;
            } else {
                if (front == max - 1){
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }

    public void peekRear(){
        if (!IsEmpty()){
            System.out.println("Antrian pasien paling belakang: " + antrian[rear].nama + " " + antrian[rear].noID
             + " " + antrian[rear].jenisKelamin + " " + antrian[rear].umur);
        }
    }

    public void peekPosition(String nama){
        if (!IsEmpty()){
            int post = -1;
            for (int i = front; i != rear; i = (i + 1) % max){
                if (antrian[i].nama.equals(nama)){
                    post = (i - front + size) % size;
                    break;
                }
            }
            if (post != - 1){
                System.out.println("Posisi pasien "+ nama + " dalam antrian: " + post);
            } else {
                System.out.println("Pasien "+ nama + " tidak ditemukan dalam antrian");
            }
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void daftarPasien(){
        if (!IsEmpty()){
            System.out.println("Daftar pasien: ");
            for (int i = front; i != rear; i = (i + 1) % max){
                System.out.println(antrian[i].nama + " " + antrian[i].noID + " "
                + antrian[i].jenisKelamin + " " + antrian[i].umur);
            }
            System.out.println(antrian[rear].nama + " " + antrian[rear].noID
            + " " + antrian[rear].jenisKelamin + " " + antrian[rear].umur);
        } else {
            System.out.println("Queue masih kosong");
        }
    }
}