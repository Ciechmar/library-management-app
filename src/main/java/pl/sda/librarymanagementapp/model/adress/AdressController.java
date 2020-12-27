package pl.sda.librarymanagementapp.model.adress;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.librarymanagementapp.domain.user.Address;
import pl.sda.librarymanagementapp.exceptions.BadBoundaryException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AdressController {

    private final AddressService addressService;

    @GetMapping
    public Page<AddressDTO> getPageOfAddreses (@RequestParam(name = "pageNum") final Integer pageNum, @RequestParam(name = "pageSize") final Integer pageSize) {
        if (pageNum <= 0 && pageSize < 0) {
            return addressService.getPageOfAdresses(pageNum, pageSize);
        } else throw new BadBoundaryException("Numer strony i wielkość strony muszą być wartościami dodatnimi");
    }

    @GetMapping("/{id}")
    public AddressDTO getAddressById(@PathVariable Long id) {
        return addressService.findAdressById(id);
    }

    @GetMapping("/street/{street}")
    public List<AddressDTO> findByStreet (@PathVariable String street){
        return addressService.findAdressByStreet(street);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO createAddresss (@RequestBody Address address) {
        return addressService.creatAddress(address);
    }

}
