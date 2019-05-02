package com.test.ibm.controller;

import com.test.ibm.dto.AdviserDto;
import com.test.ibm.service.AdviserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/adviser")
public class AdviserController {
    @Autowired
    private AdviserService adviserService;

    @RequestMapping("/page")
    public String adviser() {
        return "adviser";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody AdviserDto adviserDto) {
        adviserService.save(adviserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<String> update(@RequestBody AdviserDto adviserDto) {
        adviserService.update(adviserDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> delete(@RequestBody AdviserDto adviserDto) {
        adviserService.delete(adviserDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/list")
    public ResponseEntity<List<AdviserDto>> list() {
        return new ResponseEntity<>(adviserService.list(), HttpStatus.OK);
    }
}
