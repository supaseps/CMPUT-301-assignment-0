# CMPUT-301-assignment-0
Decision making app


## Student Details

- **Full Name:** `Seps Sepahvand`
- **CCID:** `1734521`

## References and Resources

List any resources used here, or simply put `N/A` if not applicable.

**Agent: Claude**

**Prompt:**
* in Kotlin, how can I have three buttons right next to each other
  
**Answer:**
  * In Kotlin for Android, how you do this depends on whether you're using Jetpack Compose or the classic XML view system.

Jetpack Compose (modern approach):

kotlin
@Composable
fun ThreeButtonsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(onClick = { /* action 1 */ }, modifier = Modifier.weight(1f)) {
            Text("One")
        }
        Button(onClick = { /* action 2 */ }, modifier = Modifier.weight(1f)) {
            Text("Two")
        }
        Button(onClick = { /* action 3 */ }, modifier = Modifier.weight(1f)) {
            Text("Three")
        }
    }
}

Row lays children out horizontally. Arrangement.spacedBy(8.dp) puts even gaps between them, and weight(1f) on each button makes them share the width equally — drop the weight modifier if you want them sized to their content instead.

XML layouts (View system):

xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal">

    <Button
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="One" />

    <Button
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="Two" />

    <Button
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="Three" />

</LinearLayout>

Same idea: orientation="horizontal" plus layout_weight="1" on each button splits the space evenly.

Which one are you working with — Compose or XML?

**Prompt**

* how to display something at center top of the screen kotlin android studio

**Answer**

* In Jetpack Compose, use a Box with Modifier.fillMaxSize() and align content to Alignment.TopCenter:

kotlin
@Composable
fun TopCenterExample() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = "Hello from the top!",
            modifier = Modifier.padding(top = 24.dp) // optional breathing room
        )
    }
}

Box lets you stack/position children freely, and contentAlignment = Alignment.TopCenter pins whatever's inside to the top-center of the box. Add padding(top = ...) if you don't want it flush against the very edge (e.g., under a status bar).

If you have multiple elements you want centered at the top (not just one), wrap them in a Column inside the Box:

kotlin
Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.TopCenter
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Title")
        Text("Subtitle")
    }
}

In XML, the equivalent is a RelativeLayout or ConstraintLayout with the view pinned to the top and centered horizontally, e.g. in ConstraintLayout:

xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello from the top!"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintEnd_toEndOf="parent" />

Is this going inside an existing layout (like on top of your ButtonList row), or a standalone screen?

**Prompt**

* how to show something at the bottom of the screen

**Answer**

* Same idea, just flipped to Alignment.BottomCenter (or BottomStart/BottomEnd if you don't want it centered):

kotlin
@Composable
fun BottomCenterExample() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = "Hello from the bottom!",
            modifier = Modifier.padding(bottom = 24.dp) // optional breathing room
        )
    }
}

Multiple elements at the bottom — wrap them in a Column:

kotlin
Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.BottomCenter
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Some info")
        Button(onClick = { }) { Text("Confirm") }
    }
}

A common real pattern — top content and bottom content in the same screen — is usually done with Arrangement.SpaceBetween on a Column, rather than stacking two Box calls:

kotlin
@Composable
fun TopAndBottomExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Top content")
        Text("Bottom content")
    }
}

In XML, the ConstraintLayout equivalent:

xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello from the bottom!"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintEnd_toEndOf="parent" />

Are you trying to put your ButtonList row at the bottom, with something else (like a score or title) up top?

## Verbal Collaboration

| Student Name | CCID      |
| ------------ | --------- |
| `student`    | `student` |
| `<Add more>` | `<CCID>`  |
