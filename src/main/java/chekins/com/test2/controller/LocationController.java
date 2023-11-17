package chekins.com.test2.controller;

import chekins.com.test2.model.Location;
import chekins.com.test2.repository.LocationRepository;
import chekins.com.test2.service.LocationService;
import com.redis.om.spring.autocomplete.Suggestion;
import com.redis.om.spring.repository.query.autocomplete.AutoCompleteOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
    @Autowired
    LocationService locationService;
    @GetMapping("/list")
    Iterable<Location> getAll() {
        return locationService.findAll();
    }
    @GetMapping("/search/{q}")
    public List<Suggestion> query(@PathVariable("q") String query) {
        List<Suggestion> suggestions = locationService.autocomplete(query);
        return suggestions;
    }

}
