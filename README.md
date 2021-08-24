# Assignment
## Approach

Detailing the approach for the solution for enabled mutiple language support in the app

The translations are hosted in the server in the form of json 

```json
{
  "Hello World!": {
    "hindi": "हैलो वर्ल्ड!",
    "telugu": "హలో వరల్డ్!",
    "spanish": "Hola Mundo!",
    "english": "Hola Mundo!"
  },
  "Welcome": {
    "hindi": "स्वागत",
    "telugu": "స్వాగతం",
    "spanish": "Bienvenida",
    "english": "Welcome"
  }
}
```

Each text has list of translation, json was chosen as its easy to generate and also its easy to parse in Android than a CSV file. The json file should be hosted on a CDN

Below is how you add a textview in the layout 

```java
<com.livtask.ui.main.view.TranslatedTextView
        android:id="@+id/textViewTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
```

The Custom View translates the text as per the json string and incase the translation isnt available it would continue to show the default, reasoning the approach, this would ease the developers from using the Text at their will without a need to add extra lines to translate the strings.

The main advantage with this apprach is you may add any number of languages dynamically without changing the code by adding the list of languages in the language json with the key matching the language key of the translated json. 

```json
[
  {
    "displayName": "English",
    "key": "english",
    "imageURL": ""
  },
  {
    "displayName": "Hindi",
    "key": "hindi",
    "imageURL": ""
  },
  {
    "displayName": "Telugu",
    "key": "telugu",
    "imageURL": ""
  },
  {
    "displayName": "Spanish",
    "key": "spanish",
    "imageURL": ""
  }
]
```

This way you can add new languages and add new tranlations as you change the options name through properties.


**Note: This solution is present in one of the OTT Apps since 2 years and is successfully working. This was designed by for the requirement.**
