package com.example.riken.etic.models;


import com.google.gson.annotations.SerializedName;


public class ListBioskopResponse{

	@SerializedName("jam_mulai")
	private String jamMulai;

	@SerializedName("jam_selesai")
	private String jamSelesai;

	@SerializedName("nama_bioskop")
	private String namaBioskop;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("tanggal_tayang")
	private String tanggalTayang;

	@SerializedName("jumlah_baris")
	private int jumlahBaris;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("id_bioskop")
	private int idBioskop;

	@SerializedName("harga")
	private int harga;

	@SerializedName("updated_at")
	private Object updatedAt;

	@SerializedName("id_film")
	private int idFilm;

	@SerializedName("kode_studio")
	private String kodeStudio;

	@SerializedName("id_studio")
	private int idStudio;

	@SerializedName("id")
	private int id;

	@SerializedName("kapasitas")
	private int kapasitas;

	@SerializedName("jumlah_kolom")
	private int jumlahKolom;

	public void setJamMulai(String jamMulai){
		this.jamMulai = jamMulai;
	}

	public String getJamMulai(){
		return jamMulai;
	}

	public void setJamSelesai(String jamSelesai){
		this.jamSelesai = jamSelesai;
	}

	public String getJamSelesai(){
		return jamSelesai;
	}

	public void setNamaBioskop(String namaBioskop){
		this.namaBioskop = namaBioskop;
	}

	public String getNamaBioskop(){
		return namaBioskop;
	}

	public void setCreatedAt(Object createdAt){
		this.createdAt = createdAt;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public void setTanggalTayang(String tanggalTayang){
		this.tanggalTayang = tanggalTayang;
	}

	public String getTanggalTayang(){
		return tanggalTayang;
	}

	public void setJumlahBaris(int jumlahBaris){
		this.jumlahBaris = jumlahBaris;
	}

	public int getJumlahBaris(){
		return jumlahBaris;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setIdBioskop(int idBioskop){
		this.idBioskop = idBioskop;
	}

	public int getIdBioskop(){
		return idBioskop;
	}

	public void setHarga(int harga){
		this.harga = harga;
	}

	public int getHarga(){
		return harga;
	}

	public void setUpdatedAt(Object updatedAt){
		this.updatedAt = updatedAt;
	}

	public Object getUpdatedAt(){
		return updatedAt;
	}

	public void setIdFilm(int idFilm){
		this.idFilm = idFilm;
	}

	public int getIdFilm(){
		return idFilm;
	}

	public void setKodeStudio(String kodeStudio){
		this.kodeStudio = kodeStudio;
	}

	public String getKodeStudio(){
		return kodeStudio;
	}

	public void setIdStudio(int idStudio){
		this.idStudio = idStudio;
	}

	public int getIdStudio(){
		return idStudio;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setKapasitas(int kapasitas){
		this.kapasitas = kapasitas;
	}

	public int getKapasitas(){
		return kapasitas;
	}

	public void setJumlahKolom(int jumlahKolom){
		this.jumlahKolom = jumlahKolom;
	}

	public int getJumlahKolom(){
		return jumlahKolom;
	}

	@Override
 	public String toString(){
		return 
			"ListBioskopResponse{" + 
			"jam_mulai = '" + jamMulai + '\'' + 
			",jam_selesai = '" + jamSelesai + '\'' + 
			",nama_bioskop = '" + namaBioskop + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",tanggal_tayang = '" + tanggalTayang + '\'' + 
			",jumlah_baris = '" + jumlahBaris + '\'' + 
			",alamat = '" + alamat + '\'' + 
			",id_bioskop = '" + idBioskop + '\'' + 
			",harga = '" + harga + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",id_film = '" + idFilm + '\'' + 
			",kode_studio = '" + kodeStudio + '\'' + 
			",id_studio = '" + idStudio + '\'' + 
			",id = '" + id + '\'' + 
			",kapasitas = '" + kapasitas + '\'' + 
			",jumlah_kolom = '" + jumlahKolom + '\'' + 
			"}";
		}
}