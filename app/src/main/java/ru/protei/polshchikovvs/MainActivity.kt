package ru.protei.polshchikovvs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.protei.polshchikovvs.ui.theme.PolshchikovvsTheme
import ru.protei.polshchikovvs.domain.Note
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val notes = listOf(
                Note("Сlean Architecture", "Clean Architecture " +
                        "объединила в себе идеи нескольких " +
                        "других архитектурных подходов, которые сходятся в том, " +
                        "что архитектура должна:\n" ),
                Note("Заблуждения Clean Architecture", "довольно простой набор рекомендаций " +
                        "к построению приложений."),
                Note("Заголовок 3", "Текст 3")
            )
            PolshchikovvsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NotesList(notes = notes)
                }
            }
        }
    }
}

@Composable
fun NotesList(notes: List<Note>) {
    LazyColumn {
        items(notes) { note ->
            NoteItem(note = note)
        }
    }
}

@Composable
fun NoteItem(note: Note) {
    Text(text = " ${note.title}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    Text(text = " ${note.text}", fontSize = 16.sp)
}

@Preview(showBackground = true)
@Composable
fun NotesPreview() {
    val notes = listOf(
        Note("Note 1", "Text 1"),
        Note("Note 2", "Text 2"),
        Note("Note 3", "Text 3")
    )
    PolshchikovvsTheme {
        NotesList(notes = notes)
    }
}
