package br.com.gilson.examples.service;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class SslContextInternoService {
	
	public static void main(String[] args) throws CertificateException, IOException {
		
		new SslContextInternoService().getCert();
	}
	public void getCert() throws CertificateException, IOException {
		 CertificateFactory cf = CertificateFactory.getInstance("X.509");
		 
		 String file = getClass().getResource("/itau_cert.cer").getFile();
		 //String path = getClass().getResource("/stackoverflow_cert.cer").getPath();
		 InputStream fullStream = fullStream(file);
		 X509Certificate generateCertificate = (X509Certificate)cf.generateCertificate(fullStream);
		 int basicConstraints = generateCertificate.getBasicConstraints();
	}
	
	private static InputStream fullStream ( String fname ) throws IOException {
        FileInputStream fis = new FileInputStream(fname);
        DataInputStream dis = new DataInputStream(fis);
        byte[] bytes = new byte[dis.available()];
        dis.readFully(bytes);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        return bais;
    }

}
