package com.g4tech.manager.realtime.controller;

import com.g4tech.manager.realtime.models.Bill;
import com.g4tech.manager.realtime.repositories.BillRepository;
import com.g4tech.manager.realtime.utils.ZonedDateTimeReadConverter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillRepository repository;
    private ZonedDateTimeReadConverter time;

    //GET Method
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Bill> getAllBill() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Bill getBillById(@PathVariable("id") ObjectId id) {
        return repository.findById(id);
    }

    //POST method
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createBill(@Valid @RequestBody Bill bill) {
        bill.setCheckoutTime(time.convert(Calendar.getInstance().getTime()));
        repository.save(bill);
    }
}
