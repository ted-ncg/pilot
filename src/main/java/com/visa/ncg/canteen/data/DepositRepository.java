package com.visa.ncg.canteen.data;

import com.visa.ncg.canteen.domain.Deposit;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DepositRepository {
  public DepositRepository() {
    System.out.println("DepositRepository created");
  }

  private Map<Integer, Deposit> depositMap = new HashMap<>();

  public Deposit findById(int id) {
    return depositMap.get(id);
  }

  public void save(Deposit deposit) {
    depositMap.put(deposit.getId(), deposit);
  }

  public int nextId() {
    return Sequence.nextValue();
  }
}
