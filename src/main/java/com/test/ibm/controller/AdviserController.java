package com.test.ibm.controller;

import com.test.ibm.dto.AdviserDto;
import com.test.ibm.service.AdviserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(@RequestBody AdviserDto adviserDto) {
        adviserService.save(adviserDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody AdviserDto adviserDto) {
        adviserService.update(adviserDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody AdviserDto adviserDto) {
        adviserService.delete(adviserDto);
    }

    @RequestMapping(value = "/list")
    public List<AdviserDto> list() {
        return adviserService.list();
    }
}
