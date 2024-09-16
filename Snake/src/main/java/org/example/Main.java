package org.example;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.example2.Ballot;
import org.example2.BallotApplication;
import org.example2.BallotValidator;

@Data
public class Main {

  public static void main(String[] args) {
    BallotApplication ballotApplication = new BallotApplication();
    Ballot ballot1 = new Ballot("c1", "c2", "c3");
    Ballot ballot2 = new Ballot("c2", "c3", "c1");
    Ballot ballot3 = new Ballot("c3", "c1", "c2");
    List<Ballot> ballots = new ArrayList<>();
    ballots.add(ballot1);
    ballots.add(ballot2);
    ballots.add(ballot3);

  }

}