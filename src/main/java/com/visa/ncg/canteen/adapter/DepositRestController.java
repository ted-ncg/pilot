package com.visa.ncg.canteen.adapter;

import com.visa.ncg.canteen.data.DepositRepository;
import com.visa.ncg.canteen.domain.Deposit;
import com.visa.ncg.canteen.domain.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deposits")
public class DepositRestController {

  private static final DepositRepository depositRepository = new DepositRepository();

  private final DepositService depositService;

  @Autowired
  public DepositRestController(DepositService depositService) {
    this.depositService = depositService;
  }

  @GetMapping("/{id}")
  public DepositResponse findDepositById(@PathVariable("id") int id) {
    Deposit deposit = depositRepository.findById(id);
    return new DepositResponse(deposit);
  }

  @PostMapping
  public DepositResponse createDeposit(@RequestBody DepositRequest depositRequest) {
    Deposit deposit = depositRequest.getAsDeposit();
    depositService.process(deposit);
    return new DepositResponse(deposit);
  }

}
