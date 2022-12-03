
package menuutama;
import java.text.DecimalFormat;

/**
 *
 * @author NaufalSholahuddin
 */
public class KriteriaAhp {
    /**
     * n banyak kriteria
     */
    protected int nBanyak = 4;
    /**
     * Random Index Consistency (RI)
     */
    protected double RI[] = {0.0, 0.0, 0.58, 0.90, 1.12, 1.24, 1.32, 1.41, 1.45, 1.49, 1.51, 1.48, 1.56, 1.57, 1.59};
    
    /**
     * Sebuah Matriks berpasangan Kriteria
     */
    double[][] matriksBerpasangan = new double[nBanyak][nBanyak];
    double[] jumlahMatriksBerpasangan = new double[nBanyak];
    
    /**
     * Matriks Normalisasi Kriteria
     */    
    double[][] matriksNormalisasi = new double[nBanyak][nBanyak];
    double[] jumlahMatriksNormalisasi = new double[nBanyak];
    double[] prioritas = new double[nBanyak];
    
    /**
     * Matriks Penjumlahan Kriteria
     */
    double[][] matriksPenjumlahan = new double[nBanyak][nBanyak];
    double[] jumlahMatriksPenjumlahan = new double[nBanyak];
    
    /**
     * cek konsistensi rasio kriteria
     */
    double[] jumlahCekKonsistensi = new double[nBanyak];
    
    /**
     * Format desimal
     */
    DecimalFormat df = new DecimalFormat("#.##");
    
    /**
     * Menentukan IR dari nBanyak kriteria/sub
     */
    double IR;
    //Dapatkan Nilai IR
    double getIR(){
        if(nBanyak == 1 || nBanyak == 2){
            IR = RI[0];
        }else if(nBanyak == 3){
            IR = RI[2];
        }else if(nBanyak == 4){
            IR = RI[3];
        }else if(nBanyak == 5){
            IR = RI[4];
        }else if(nBanyak == 6){
            IR = RI[5];
        }else if(nBanyak == 7){
            IR = RI[6];
        }else if(nBanyak == 8){
            IR = RI[7];
        }else if(nBanyak == 9){
            IR = RI[8];
        }else if(nBanyak == 10){
            IR = RI[9];
        }
        return IR;
    }
    //set Nilai
    public void setNilaiKriteria(){
        //nilai dari matriks berapasangan kriteria
        double matriks[][] = {
            {1, 5.0, 7.0, 9.0},
            {1.0/5.0, 1, 5.0, 7.0},
            {1.0/7.0, 1.0/5.0, 1, 5.0},
            {1.0/9.0, 1.0/7.0, 1.0/5.0, 1}
        };
        for (int row = 0; row < nBanyak; row++) {
            for (int col = 0; col < nBanyak; col++) {
                matriksBerpasangan[row][col] =  matriks[row][col];
            }
        }
    }
    //Membuat Matriks Kriteria Normalisasi Metode AHP
    public void MatriksBerpasangan(){
        //masukkan nilai matriks berpasangan
        setNilaiKriteria();
        //Jumlah PerKolom Pada Matriks berpasangan 
        for (int row = 0; row < nBanyak; row++) {
            for (int col = 0; col < nBanyak; col++) {
                jumlahMatriksBerpasangan[col] +=  matriksBerpasangan[row][col];
            }
        }
    }
    //membuat matriks normalisasi kriteria
    public void MatriksNormalisasi(){
        //perhitungan nilai dari matriks normalisasi kriteria
        //Jumlah setiap baris dan nilai prioritas
        for (int row = 0; row < nBanyak; row++) {
            for (int col = 0; col < nBanyak; col++) {
                matriksNormalisasi[row][col] = matriksBerpasangan[row][col]/jumlahMatriksBerpasangan[col];
                jumlahMatriksNormalisasi[row] += matriksNormalisasi[row][col];
                prioritas[row] = jumlahMatriksNormalisasi[row]/nBanyak; 
            }
        }
    }
    
    //membuat matriks penjumlahan setiap baris untuk kriteria
    public void MatriksPenjumlahan(){
        for (int row = 0; row < nBanyak; row++) {
            for (int col = 0; col < nBanyak; col++) {
                matriksPenjumlahan[row][col] = matriksBerpasangan[row][col]*prioritas[col];
                jumlahMatriksPenjumlahan[row] += matriksPenjumlahan[row][col];
            }
        }
    }
    
    //cek konsistensi rasio kriteria
    public String getCekKonsistensi(){
        double totalJumlah=0;
        for (int row = 0; row < nBanyak; row++) {
            jumlahCekKonsistensi[row] = jumlahMatriksPenjumlahan[row] + prioritas[row];
            totalJumlah += jumlahCekKonsistensi[row];
        }
        double ir = getIR();
        double lamdaMaks = totalJumlah/nBanyak;
        double CI=(lamdaMaks-nBanyak)/(nBanyak-1);
        double CR=CI/ir;
        if(CR <= 0.1){
            return "Konsisten";
        }else{
            return "Tidak Konsisten"; 
        }    
   }
    public KriteriaAhp(){
        MatriksBerpasangan();
        MatriksNormalisasi();
        MatriksPenjumlahan();
    }
}
