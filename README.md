# pollen-api
Spring boot REST API for Croatian pollen forecast


## How to run
The API isn't available online so you will need to run it locally. For that you will need Java 17 (or later) installed.

Download the "pollen-api-0.0.1-SNAPSHOT.jar" file, located inside "pollen-api" folder, and run it. To run it using cmd, inside cmd navigate to the folder where you saved the file using the command "cd folderpath".
After that type the command "java -jar pollen-api-0.0.1-SNAPSHOT.jar". To close the application inside cmd press ctrl+c.

You can also run the jar file by simply opening the file but then you will need to close it using task manager.

## Usage
The API runs on port 8080 so to access it you will need to type in the url "http://localhost:8080" into your internet browser.

There are two different url paths "/cities" and "/cities/{cityName}". (To access them simply add them to the end of initial url, for example "http://localhost:8080/cities")

"/cities" returns a list of available cities.

Output:
```json
[
  "split",
  "osijek",
  "varazdin",
  "zagreb",
  "virovitica",
  "zadar",
  "dubrovnik",
  "pula"
]
```


"/cities/{cityName}" returns pollen data for the requested city.

Output for city Pula:
```json
{
  "name": "Pula",
  "pollenList": [
    {
      "name": "Borovi",
      "date": "29.03.",
      "value": 9.5
    },
    {
      "name": "Čempresi",
      "date": "29.03.",
      "value": 3.6
    },
    {
      "name": "Grab",
      "date": "29.03.",
      "value": 3
    },
    {
      "name": "Vrba",
      "date": "29.03.",
      "value": 0.8
    },
    {
      "name": "Jasen",
      "date": "29.03.",
      "value": 0.6
    }
  ]
}
```


