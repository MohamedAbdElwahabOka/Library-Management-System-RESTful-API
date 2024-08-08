package com.Library.Library.Patron;

import com.Library.Library.Book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronService {

    private final PatronRepository patronRepository;
    @Autowired
    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public List<Patron> getPatrons() {
        return patronRepository.findAll();
    }

    public Patron getPatronById(Long id) {
        Optional<Patron> patron = patronRepository.findById(id);
        if (!patron.isPresent()) {
            throw new IllegalStateException("patron with id " + id + " not found");
        }
        return patron.get();
    }

    public Patron createPatron(Patron patron) {
        return patronRepository.save(patron);
    }
    public Patron updatePatron(Long id, Patron PatronDetails) {
        Patron patron = patronRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Patron with id " + id + " not found"));

        if(PatronDetails.getName() != null){
            patron.setName(PatronDetails.getName());
        }
        if(PatronDetails.getEmail() != null){
            patron.setEmail(PatronDetails.getEmail());
        }
        if(PatronDetails.getPhone() != null){
            patron.setPhone(PatronDetails.getPhone());
        }
        if (PatronDetails.getAddress() != null){
            patron.setAddress(PatronDetails.getAddress());
        }
        if (PatronDetails.getZip() != null){
            patron.setZip(PatronDetails.getZip());
        }

        return patronRepository.save(patron);
    }

    public void deletePatron(Long id) {
        if (!patronRepository.existsById(id)) {
            throw new IllegalStateException("Patron with id " + id + " not found");
        }
        patronRepository.deleteById(id);
    }

}
