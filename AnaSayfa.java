// BATUHAN AYDOGDU 21100011024
package sdacf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class AnaSayfa {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		ArrayList<Ders> dersler= new ArrayList<Ders>();
		ArrayList<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
		ArrayList<Ogrenci> ogrenciler2 = new ArrayList<Ogrenci>();
		ArrayList<Ders> ogrdersler= new ArrayList<Ders>();
		ArrayList<Ders> ogrdersler2= new ArrayList<Ders>();
		ArrayList<Ders> sildersler= new ArrayList<Ders>();
		ArrayList<Ogrenci> silogrler = new ArrayList<Ogrenci>();
		ArrayList<Ders> ogrenci_dersler= new ArrayList<Ders>();
		ArrayList<Ders> temp = null;
		ArrayList<String> tutders=new ArrayList<String>();
		String okunanders="",okunanogr="";
		String dersdizi[];
		String ogrdizi[];
		String ogrdersdizi[];
		int derssayi;
		int sayac=0;
		boolean kontrol=true;
		int silkontrol=0;
		int silders=0;
		
		File dosyaders=new File("ders.txt");
		FileReader firead= new FileReader(dosyaders);
		BufferedReader bread= new BufferedReader(firead);
		
		while((okunanders=bread.readLine())!=null)
		{	
			dersdizi=okunanders.split("%");
			derssayi=Integer.parseInt(dersdizi[0]);
			dersler.add(new Ders(derssayi,dersdizi[1]));
		}
		firead.close();
		bread.close();
		
		File dosyaogr = new File("ogrenci.txt");
		FileReader fran = new FileReader(dosyaogr);
		BufferedReader breaad= new BufferedReader(fran);
		String ogrenciad = null;
		int ogrenciid = 0;
		int ogrenciyas = 0;
		int dersno = 0;
		String dersad ="";
		int sayac2=0;
		while((okunanogr=breaad.readLine())!=null)
		{
			ogrdizi=okunanogr.split("%");
			
			if(okunanogr.startsWith("+"))
			{
				ogrdersler2.clear();
				if(sayac2!=0) {
					ogrenciler.add(new Ogrenci(ogrenciid,ogrenciad,ogrenciyas,temp));
					
				}
				sayac2=0;
				ogrenciid=Integer.parseInt(ogrdizi[0]);
				ogrenciad=ogrdizi[1];
				ogrenciyas=Integer.parseInt(ogrdizi[2]);

			}	
			if(okunanogr.startsWith("*") )
			{
				ogrdizi[0]=ogrdizi[0].substring(1);
				dersno=Integer.parseInt(ogrdizi[0]);
				dersad=ogrdizi[1];
				ogrdersler2.add(new Ders(dersno,dersad));
				temp=(ArrayList<Ders>) ogrdersler2.clone();
				sayac2++;
			}
			
			
		}
		ogrenciler.add(new Ogrenci(ogrenciid,ogrenciad,ogrenciyas,ogrdersler2));				

		
		int case_5_ogrsayi,ogrenci_id,ogrenci_yas,ogr_aranacak,derssayac,ogr_silinecek,ders_id;
		String ekleders,ders_aranacak,ders_silinecek,ogrenci_ad,ders_ad,ogrenci_soyad,ad_soyad;
		
		
		while(kontrol)
		{
			
			int swich=0;
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------------------------");

			System.out.println("Lutfen secim yapiniz-->");
			System.out.println("1--<Ogrenci ekle>--");
			System.out.println("2--<Ders ekle>--");
			System.out.println("3--<Ogrenci Listele>--");
			System.out.println("4--<Ders Listele>--");
			System.out.println("5--<Ogrenci Ara>--");
			System.out.println("6--<Ders Ara>--");
			System.out.println("7--<Ogrenci Sil>--");
			System.out.println("8--<Ders Sil>--");
			System.out.println("9--<Ogrenci Ayrintili Listele>--");
			System.out.println("10--<Ogrenci Tutar Hesapla>--");
			System.out.println("11--<Cikis>--");

			swich=scan.nextInt();
			switch(swich)
			{
			
		case 1:
			System.out.println("Kac ogrenci girmek istiyorsunuz-->");
			case_5_ogrsayi=scan.nextInt();
			for(int k=0;k<case_5_ogrsayi;k++)
			{
				System.out.println("Eklenecek ogrencinin Idini giriniz");
				ogrenci_id=scan.nextInt();
				System.out.println("Eklenecek ogrencinin ad giriniz");
				ogrenci_ad=scan.next();
				System.out.println("Eklenecek ogrencinin ad giriniz");
				ogrenci_soyad=scan.next();
				ad_soyad=ogrenci_ad+" "+ogrenci_soyad;
				System.out.println("Eklenecek ogrencinin yas giriniz");
				ogrenci_yas=scan.nextInt();
				
				for(Ders deri:dersler)
				{
					System.out.println(deri.getDersId()+" "+deri.getDersAd());	
				}
				
				System.out.println("Kaydolabileceginiz dersler yukarida gosterilmistir");
				System.out.println("Kac derse kaydolmak istiyorsunuz-->");
				derssayi=scan.nextInt();
				for(int i=0;i<derssayi;i++)
				{
					System.out.println("Dersin adini giriniz");
					ders_ad=scan.next();
					System.out.println("Dersin id degerini giriniz");
					ders_id=scan.nextInt();
					ogrenci_dersler.add(new Ders(ders_id,ders_ad));
				}		
				
				ogrenciler.add(new Ogrenci(ogrenci_id,ad_soyad,ogrenci_yas,ogrenci_dersler));
			}
			
			break;
			
		case 2:
			System.out.println("Eklenecek dersin adini giriniz");
			ekleders = scan.next();
			dersler.add(new Ders(ekleders));
			break;
				
		case 3:
			for(Ogrenci bosogr2:ogrenciler)
			{
				System.out.println("Ogrencinin Adi--->"+bosogr2.getOgrAdSoyad());
				System.out.println("Ogrenci ID'si--->"+bosogr2.getOgrId());
				System.out.println("Ogrenci Yasi--->"+bosogr2.getOgrYas());
			}
			break;
			
		case 4:
			
			for(Ders dersbos:dersler)
			{
				System.out.println("Ders no="+dersbos.getDersId());
				System.out.println("ders adi="+dersbos.getDersAd());
			}
		
			break;
			
		case 5:
			
			System.out.println("Aranacak Ogrencinin numarasini giriniz ");
			ogr_aranacak=scan.nextInt();
			for(Ogrenci ogrm:ogrenciler)
			{
				if(ogrm.getOgrId()==(ogr_aranacak))
				{
					System.out.println(ogrm.getOgrId());
					System.out.println(ogrm.getOgrAdSoyad());
					System.out.println(ogrm.getOgrYas());
					break;
				}
				else
				{
					System.out.println("Ogrenci bulunamadi");
				}
			}
			break;
			
		case 6:
			System.out.println("Aranacak dersin adini giriniz-->");
			ders_aranacak=scan.next();
			for(Ders bas:dersler)
			{
				if(bas.getDersAd().equals(ders_aranacak))
				{
					System.out.println("Ders Mevcut");
					System.out.println("Dersin adi-->"+bas.getDersAd());
					System.out.println("Dersin Id--->"+bas.getDersId());
					silkontrol=1;
				}
			}
			if(silkontrol==0)
				System.out.println("Ders Bulunamadi");
			break;
		
		case 7:
			System.out.println("Silinecek Ogrencinin Id'sini giriniz-->");
			ogr_silinecek=scan.nextInt();
			for(Ogrenci ogrm:ogrenciler)
			{
				if(ogrm.getOgrId()==(ogr_silinecek))
				{
					continue;
				}
				else
				{
					silogrler.add(ogrm);
				}
				
			}
			ogrenciler=(ArrayList<Ogrenci>) silogrler.clone();	
			break;
			

		case 8:
			System.out.println("Silinecek dersin adini giriniz--");
			ders_silinecek=scan.next();
		
			for(Ogrenci or:ogrenciler)
			{
				for(Ders deraw:or.alinanDersler)
					if(deraw.getDersAd().equals(ders_silinecek))
					{
						silders++;
						System.out.println("Bu ders silinemez");
					}
				
			}
			
			if(silders==0)
			{
				for(Ders bos:dersler)
				{
					if(bos.getDersAd().equals(ders_silinecek))
					{
						continue;
					}
					else
					{
						sildersler.add(bos);
					}
					
				}
				dersler=(ArrayList<Ders>) sildersler.clone();		
			}
				
			
			break;
			
		case 9:
			for(Ogrenci bosogr:ogrenciler)
			{
				System.out.println("Ogrencinin Adi--->"+bosogr.getOgrAdSoyad());
				System.out.println("Ogrenci ID'si--->"+bosogr.getOgrId());
				System.out.println("Ogrenci Yasi--->"+bosogr.getOgrYas());
				derssayac=bosogr.alinanDersler.size();
				for(int i=0;i<derssayac;i++)
				{
					System.out.println((i+1)+". Dersin Id'si-->"+bosogr.alinanDersler.get(i).getDersId());
					System.out.println((i+1)+". Dersin Adi-->"+bosogr.alinanDersler.get(i).getDersAd());

				}
				
			}
			
			break;
			
		case 10:
			int fiyatid,fiyatderssayi;
			double anafiyat=400;
			double indirim;
			double indirimli_fiyat;
			double son_fiyat;
			System.out.println("Fiyati hesaplanacak ogrencinin id'sini giriniz-->");
			fiyatid=scan.nextInt();
			for(Ogrenci ogrfi:ogrenciler)
			{
				if(ogrfi.getOgrId()==fiyatid)
				{
					fiyatderssayi=ogrfi.alinanDersler.size();
					if(fiyatderssayi==1)
					{
						System.out.println("Herhangi bir kampanyaya dahil edilmediniz.\nOdemeniz gereken tutar"+anafiyat);
					}
					if(fiyatderssayi==2)
					{
						indirim=anafiyat*0.05;//inidirim oranı
						indirimli_fiyat=400-indirim;
						son_fiyat=anafiyat+indirimli_fiyat;
						System.out.println("Kampanya 1'e dahil edildiniz.\nOdemeniz gereken tutar"+son_fiyat);

					}
					if(fiyatderssayi==3)
					{
						indirim=anafiyat*0.15;
						indirimli_fiyat=400-indirim;
						son_fiyat=(anafiyat*2)+indirimli_fiyat;
						System.out.println("Kampanya 2'ye dahil edildiniz.\nOdemeniz gereken tutar"+son_fiyat);
					}
					if(fiyatderssayi>3)
					{
						indirim=anafiyat*0.10;
						indirimli_fiyat=400-indirim;
						son_fiyat=indirimli_fiyat*fiyatderssayi;
						System.out.println("Kampanya 3'e dahil edildiniz.\nOdemeniz gereken tutar"+son_fiyat);

						
					}
					
				}
				
				
			}
			
			
			break;
		case 11:
			FileWriter fread = new FileWriter(dosyaogr);
			BufferedWriter bwrit=new BufferedWriter(fread);
			
			for(Ogrenci ogryaz:ogrenciler)
			{
				bwrit.write("+"+ogryaz.getOgrId()+"%"+ogryaz.getOgrAdSoyad()+"%"+ogryaz.getOgrYas()+"\n");
				for(Ders deryaz:ogryaz.alinanDersler)
				{
					bwrit.write("*"+deryaz.getDersId()+"%"+deryaz.getDersAd()+"\n");
				}
			}
			FileWriter fread2 = new FileWriter(dosyaders);
			BufferedWriter bwrit2=new BufferedWriter(fread2);
			
			for(Ders deryaz2:dersler)
			{
				bwrit2.write(deryaz2.getDersId()+"%"+deryaz2.getDersAd()+"\n");
			}
			
			bwrit.flush();
			bwrit2.flush();
			
			kontrol=false;
			break;
			
			}
			
			
		}
		
	
		
}
}