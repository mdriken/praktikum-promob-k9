package com.example.riken.etic.models;


import com.google.gson.annotations.SerializedName;


public class DataItem{

	@SerializedName("foto_film")
	private String fotoFilm;

	@SerializedName("status_tayang")
	private String statusTayang;

	@SerializedName("tanggal_selesai")
	private String tanggalSelesai;

	@SerializedName("tgl_mulai")
	private String tglMulai;

	@SerializedName("id")
	private int id;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("nama_genre")
	private String namaGenre;

	@SerializedName("durasi")
	private String durasi;

	@SerializedName("nama_film")
	private String namaFilm;

	@SerializedName("nama_kategori")
	private String namaKategori;

	public void setFotoFilm(String fotoFilm){
		this.fotoFilm = fotoFilm;
	}

	public String getFotoFilm(){
		return fotoFilm;
	}

	public void setStatusTayang(String statusTayang){
		this.statusTayang = statusTayang;
	}

	public String getStatusTayang(){
		return statusTayang;
	}

	public void setTanggalSelesai(String tanggalSelesai){
		this.tanggalSelesai = tanggalSelesai;
	}

	public String getTanggalSelesai(){
		return tanggalSelesai;
	}

	public void setTglMulai(String tglMulai){
		this.tglMulai = tglMulai;
	}

	public String getTglMulai(){
		return tglMulai;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public void setNamaGenre(String namaGenre){
		this.namaGenre = namaGenre;
	}

	public String getNamaGenre(){
		return namaGenre;
	}

	public void setDurasi(String durasi){
		this.durasi = durasi;
	}

	public String getDurasi(){
		return durasi;
	}

	public void setNamaFilm(String namaFilm){
		this.namaFilm = namaFilm;
	}

	public String getNamaFilm(){
		return namaFilm;
	}

	public void setNamaKategori(String namaKategori){
		this.namaKategori = namaKategori;
	}

	public String getNamaKategori(){
		return namaKategori;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"foto_film = '" + fotoFilm + '\'' + 
			",status_tayang = '" + statusTayang + '\'' + 
			",tanggal_selesai = '" + tanggalSelesai + '\'' + 
			",tgl_mulai = '" + tglMulai + '\'' + 
			",id = '" + id + '\'' + 
			",deskripsi = '" + deskripsi + '\'' + 
			",nama_genre = '" + namaGenre + '\'' + 
			",durasi = '" + durasi + '\'' + 
			",nama_film = '" + namaFilm + '\'' + 
			",nama_kategori = '" + namaKategori + '\'' + 
			"}";
		}
}