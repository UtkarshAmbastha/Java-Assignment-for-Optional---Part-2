package com.knoldus;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookCrawlerTests {
@Rule
    public ExpectedException expectedException = ExpectedException.none();

private final PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBook());

@Test
    public void findPhoneNUmberByNameAndPunishIfNothingFound () {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("No Number found");

    phoneBookCrawler.findPhoneNUmberByNameAndPunishIfNothingFound("Amanadiel");
}

@Test
    public void findNumberByName_CorrectIfFound(){
    String actualNumber = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Utkarsh");
    assertThat(actualNumber).isEqualTo("7991133566");
}

@Test
    public void findNumberByNameAndReturnEntirePhoneBookIfNothingFound() {
    String actualBook = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Cloe");
    assertThat(actualBook).isEqualTo("PhoneBook{ PhoneBook = {Utkarsh=7991133566, Lucifer=9471305808}}");
}

@Test
    public void findNumberByNameOrNameByPhoneNumber_CorrectIfFoundByName() {
    String actualNumber = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Utkarsh", "6578943201");
    assertThat(actualNumber).isEqualTo("7991133566");
}

@Test
    public void findNumberByNameOrNameByNumber_CorrectIfFoundByNumber () {
    String name = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Denver", "9471305808");
    assertThat(name).isEqualTo("Lucifer");
}


}
