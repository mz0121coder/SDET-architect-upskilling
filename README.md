# SDET-architect-upskilling

## Notes for running tests (from Grid section onwards)

Current state of framework (as of 8 August 2024):

- open `04-selenium-grid/05-dockerise/04-scale-browser` in terminal
- run `sh run.sh` to set up grid, spin up tests, run them in containers with parallel execution, then save output (including reports) within same directory, followed by teardown & cleanup

## Previous notes (just for practice)

### Disposable grid infrastructure (spin up/tear down as needed)

- Run Docker desktop
- From the relevent directory containing a docker-compose file with a `seleniarm` image (for mac) run `docker-compose up` then check specified port e.g. http://localhost:4444
- `docker-compose down` afterwards

### Specify test suite

In the following commands, change the name to run the desired test suite from this folder: `selenium-docker/src/test/resources/test-suites`

- flight-reservation.xml for flight reservation tests
- vendor-portal.xml for vendor portal tests

### TestNG parameters

- Running a test suite

`java -cp 'libs/*' org.testng.TestNG test-suites/flight-reservation.xml`

- Running a test suite with specific thread count

`java -cp 'libs/*' org.testng.TestNG -threadcount 2 test-suites/flight-reservation.xml`

- TestNG by default creates **test-output** directory. You can change it with **-d** option.

`java -cp 'libs/*' org.testng.TestNG -threadcount 2 -d result test-suites/flight-reservation.xml`

---

### System Properties

- To pass the browser option

`java -Dbrowser=chrome -cp 'libs/*' org.testng.TestNG test-suites/flight-reservation.xml`

- To run the tests using Selenium Grid

`java -Dselenium.grid.enabled=true -Dselenium.grid.hubHost=localhost -cp 'libs/*' org.testng.TestNG test-suites/flight-reservation.xml`

- To run the tests using Selenium Grid with specific thread count

`java -Dselenium.grid.enabled=true -Dselenium.grid.hubHost=localhost -cp 'libs/*' org.testng.TestNG test-suites/flight-reservation.xml -threadcount 2`
