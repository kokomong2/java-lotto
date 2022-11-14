package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Player {

    int money ;
    List<Lotto> lottos;

    public Player(){
        this.lottos = new ArrayList<>();
    }

    public Player(int money){
        this.lottos = buyLottos(howManyLotto(money));
        this.money = money;
    }

    public int howManyLotto(int money){
        if(money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위로 떨어져야 합니다.");
        }
        return money/1000;
    }

    public List<Lotto> buyLottos(int moneyCount){

        List<Lotto> sampleLottos = new ArrayList<>();
        for (int i = 0; i < moneyCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            sampleLottos.add(lotto);
        }
        return sampleLottos;
    }

    public void printLottos(){
        for(Lotto lotto : lottos){
            lotto.printLotto();
        }
    }

}
