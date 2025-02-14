package io.github.mauricio_mds.android_basics_task_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.mauricio_mds.android_basics_task_manager.ui.theme.AndroidbasicstaskmanagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidbasicstaskmanagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskManagerApp(
                        painter = painterResource(id = R.drawable.ic_task_completed),
                        status = stringResource(R.string.all_tasks_completed),
                        message = stringResource(R.string.nice_work),
                        modifier = Modifier.padding(innerPadding).fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun TaskManagerApp(
    painter: Painter, status: String, message: String, modifier: Modifier = Modifier
) {
    TaskManager(
        painter = painter,
        status = status,
        message = message,
        modifier = modifier
    )
}

@Composable
fun TaskManager(painter: Painter, status: String, message: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(painter = painter, contentDescription = null)
        Text(
            text = status,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(text = message, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidbasicstaskmanagerTheme {
        TaskManagerApp(
            painter = painterResource(id = R.drawable.ic_task_completed),
            status = stringResource(R.string.all_tasks_completed),
            message = stringResource(R.string.nice_work),
            modifier = Modifier.fillMaxSize()
        )
    }
}