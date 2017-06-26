package imie.utils.modelmapper.tests;

public class ModelMapperTest {

	/*private Logger log = LoggerFactory.getLogger(ModelMapperTest.class);

	private Person person;
	private House house;

	@Before
	public void setUp() throws Exception {

		String[] address = { "3 rue de la Rigourdière", "35000", "Rennes" };
		String[] children = { "Victor", "Alexander", "Marie" };

		house = new House(address, null);

		person = new Person("Gaillard", "Fabien", 28, 85, 1.86f, "02.97.35.36.21", new House[] { house }, children,
				new Dog("Medor"));

		house.setPersons(Arrays.asList(person));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void mappingFromPerson() throws Exception {
		ModelMapper mapper = new ModelMapper(person);
		PersonDto dto = (PersonDto) mapper.convert();

		Assert.assertThat(dto.getFirstName(), is("Fabien"));
		Assert.assertThat(dto.getLastName(), is("Gaillard"));
		Assert.assertThat(dto.getAge(), is(28));
		Assert.assertThat(dto.getSize(), is(1.86f));
		Assert.assertThat(dto.getPhone(), is("02.97.35.36.21"));
		Assert.assertThat(dto.getDog(), not(nullValue()));
		Assert.assertThat(dto.getDog().getName(), is("Medor"));

		// log.info(dto.toString());

		Assert.assertThat(dto.getHouses(), not(nullValue()));
		Assert.assertThat(dto.getHouses().length, is(1));

	}

	@Test
	public void mappingFromHouse() throws Exception {
		ModelMapper mapper = new ModelMapper(house);
		HouseDto dto = (HouseDto) mapper.convert();

		// log.info(dto.toString());

		Assert.assertThat(dto.getPersons(), not(nullValue()));
		Assert.assertThat(dto.getPersons().size(), is(1));

	}*/

}
