package com.mydeveloperplanet.myjavafakerplanet;

import java.util.Locale;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyJavaFakerPlanetApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void addressFaker() {
		Faker faker = new Faker();

		String firstName = faker.address().firstName();
		String lastName = faker.address().lastName();
		String streetName = faker.address().streetName();

		System.out.println("First name: " + firstName);
		System.out.println("Last name: " + lastName);
		System.out.println("Street name: " + streetName);
	}

	@Test
	void addressNlFaker() {
		Faker faker = new Faker(new Locale("nl-NL"));

		String firstName = faker.address().firstName();
		String lastName = faker.address().lastName();
		String streetName = faker.address().streetName();

		System.out.println("First name: " + firstName);
		System.out.println("Last name: " + lastName);
		System.out.println("Street name: " + streetName);
	}

	@Test
	void fakeValuesServiceNumerify() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("nl-NL"), new RandomService());
		String randomNumber = fakeValuesService.numerify("number##");

		System.out.println("Random number is: " + randomNumber);
	}

	@Test
	void fakeValuesServiceLetterify() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("nl-NL"), new RandomService());
		String randomLetters = fakeValuesService.letterify("somestring??");

		System.out.println("Random letters are: " + randomLetters);
	}

	@Test
	void fakeValuesServiceBothify() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("nl-NL"), new RandomService());
		String randomNumbersLetters = fakeValuesService.bothify("some string with numbers ## and letters ??");

		System.out.println("Random numbers and letters are: " + randomNumbersLetters);
	}

	@Test
	void fakeValuesServiceRegexify() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("nl-NL"), new RandomService());
		String randomBasedRegex = fakeValuesService.regexify("[abc]+\\s\\d");

		System.out.println("Random string based on a pattern: " + randomBasedRegex);
	}

	@Test
	void fakeValuesServiceFetchCountry() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("nl-NL"), new RandomService());
		String fetchedCountry = fakeValuesService.fetchString("address.country");

		System.out.println("The fetched country is: " + fetchedCountry);
	}



}
