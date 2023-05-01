package com.miniproject.Peserta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import java.io.File;
// import java.io.IOException;

// import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.miniproject.Email.EmailService;
import com.miniproject.QrCode.MyQr;
import jakarta.mail.MessagingException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PesertaController {
    @Autowired
    private PesertaRepo pesertaRepo;

    @Autowired
    private EmailService emailService;

    // @Autowired
    // private static MyQr myQr;

    // Get All Data Participant
    // public Iterable<Peserta> index() {
    // return pesertaRepo.findAll();
    // }

    @GetMapping("/api/peserta")
    public List<Peserta> getAllPeserta() {
        List<Peserta> peserta = new ArrayList<Peserta>();
        pesertaRepo.findAll().forEach(p -> peserta.add(p));
        return peserta;
    }

    // Save and Update Data Participant
    @PostMapping("/api/savePeserta")
    public Peserta saveOrUpdate(Peserta savePeserta) throws MessagingException {
        Peserta peserta = pesertaRepo.findPesertaByUniqueCode(savePeserta.getUniquecode());
        if (peserta != null) {
            peserta.setTanggaldaftar(savePeserta.getTanggaldaftar());
            peserta.setEmail(savePeserta.getEmail());
            peserta.setNama(savePeserta.getNama());
            peserta.setNowa(savePeserta.getNowa());
            peserta.setJeniskelamin(savePeserta.getJeniskelamin());
            peserta.setUsia(savePeserta.getUsia());
            peserta.setParoki(savePeserta.getParoki());
            peserta.setBuktibayar(savePeserta.getBuktibayar());
            peserta.setNamakomunitas(savePeserta.getNamakomunitas());
            peserta.setMasuk(savePeserta.getMasuk());
            peserta.setWaktumasuk(savePeserta.getWaktumasuk());
            peserta.setUser(savePeserta.getUser());
        } else {
            peserta = new Peserta();
            peserta.setUniquecode(savePeserta.getUniquecode());
            peserta.setTanggaldaftar(savePeserta.getTanggaldaftar());
            peserta.setEmail(savePeserta.getEmail());
            peserta.setNama(savePeserta.getNama());
            peserta.setNowa(savePeserta.getNowa());
            peserta.setJeniskelamin(savePeserta.getJeniskelamin());
            peserta.setUsia(savePeserta.getUsia());
            peserta.setParoki(savePeserta.getParoki());
            peserta.setBuktibayar(savePeserta.getBuktibayar());
            peserta.setNamakomunitas(savePeserta.getNamakomunitas());
            run(savePeserta.getUniquecode());
            String subject = "QR Code Check In";
            String message = "Hi, " + savePeserta.getNama()
                    + "\nParticipant Registered Successfully. This is your QR CODE for check in.\n" + "Thank you.";
            emailService.sendEmailAttachment(subject, message, savePeserta.getEmail(),
                    true, new File("QRCODE_CHECK_IN.png"));
        }
        return pesertaRepo.save(peserta);
    }

    // Delete data
    @DeleteMapping("/api/delPeserta/{uniquecode}")
    public void deleteByUniquecode(@PathVariable("uniquecode") String uniquecode) {
        pesertaRepo.deleteById(uniquecode);
    }

    // Run QRCode funtion
    protected void run(String data) {

        // The path where the image will get saved
        String path = "QRCODE_CHECK_IN.png";

        // Encoding charset
        String charset = "UTF-8";

        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                ErrorCorrectionLevel.L);

        // Create the QR code and save
        // in the specified folder
        // as a jpg file
        try {
            MyQr.createQR(data, path, charset, hashMap, 200, 200);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("QR Code Generated!!! ");
    }
}
