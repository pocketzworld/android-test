# Android candidate test

## Your task

Fork this repo. Explore existing code. It has some good bits and some bad bits. Feel free to change anything. Actually, feel free to not use this code at all and do your own project. We've made it to save you some time and to highlight some expectations, like writing tests.

- Get [this C++ class](https://gist.github.com/uwjimmyxu/511e76914e280d502dca3f34bacdcfb1) that will act as your data source and use it instead of the dummy data source that is currently there
- Create detail screen for a movie
- Add bottom tabs. It should have 2 tabs.
    - First tab should contain existing view that shows a list of movies
    - Second tab should contain a grid of same movies
    - Tapping on a movie in either tab should open detail screen within same tab
    - Each tab should have a separate backstack. So if you open movie detail screen in first tab, then go to second tab, then go to first tab again - movie detail screen should be visible
- Add ability to like a movie
    - Should be able to like a movie in first tab with a list
    - Should be able to like a movie in second tab with a grid
    - Should be able to like a movie in detail screen
    - When like state changes, it should be reflected in all 3 screens (handling everything in memory is OK)
- Anything else you want to do
    - Improve the UI
    - Use any library you want
