package pl.rabbadak.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class AvroConsumerApplicationTests {

	@Test
	void contextLoads() {

		// Creating a List of Lists
		List<List<String>> listOfLists = Arrays.asList(
				Arrays.asList("Geeks", "For"),
				Arrays.asList("GeeksForGeeks", "A computer portal"),
				Arrays.asList("Java", "Programming")
		);

		// Using Stream flatMap(Function mapper)
		listOfLists.stream()
				.flatMap(list -> list.stream())
				.forEach(System.out::println);

	}

}
