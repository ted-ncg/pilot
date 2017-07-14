package com.visa.ncg.canteen.adapter;

import com.visa.ncg.canteen.domain.Deposit;
import com.visa.ncg.canteen.domain.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposits")
public class DepositRestController {

  private final DepositService depositService;

  @Autowired
  public DepositRestController(DepositService depositService) {
    this.depositService = depositService;
  }

  @PostMapping
  public DepositResponse createDeposit(@RequestBody DepositRequest depositRequest) {
    Deposit deposit = depositRequest.getAsDeposit();
    depositService.process(deposit);
    return new DepositResponse(deposit);
  }

}
