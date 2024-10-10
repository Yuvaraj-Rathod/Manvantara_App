import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.manvantara.R
import com.example.manvantara.viewmodel.AuthState
import com.example.manvantara.viewmodel.AuthViewModel

@Composable
fun LoginPage(modifier: Modifier = Modifier,navController: NavController,authViewModel: AuthViewModel) {
    var Email by remember { mutableStateOf("") }
    var Password by remember { mutableStateOf("") }
    val context = LocalContext.current.applicationContext
    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Authenticated -> navController.navigate("homepage")
            is AuthState.Error -> Toast.makeText(
                context, (authState.value as AuthState.Error).message,
                Toast.LENGTH_SHORT
            ).show()

            else -> Unit
        }
    }

    Column( modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 90.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.Top,
        Alignment.CenterHorizontally,) {
        Image(painter = painterResource(id = R.drawable.swagatam),
            contentDescription = "swagatam",
            modifier = Modifier.padding(top = 10.dp)
                .size(380.dp))

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 140.dp, horizontal = 26.dp)
        ,
        verticalArrangement = Arrangement.Bottom,
        Alignment.CenterHorizontally,

        ) {
        OutlinedTextField(
            value = Email, onValueChange = { Email = it },
            label = { Text(text = "Email") },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Black,
                unfocusedContainerColor = Color.Black,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                focusedLeadingIconColor = Color.Cyan,
                unfocusedLeadingIconColor = Color.Cyan,
                focusedIndicatorColor = Color.Cyan,
                unfocusedIndicatorColor = Color.Cyan,
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = Password, onValueChange = { Password = it },
            shape = RoundedCornerShape(20.dp),
            label = { Text(text = "Password") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Black,
                unfocusedContainerColor = Color.Black,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                focusedLeadingIconColor = Color.Cyan,
                unfocusedLeadingIconColor = Color.Cyan,
                focusedIndicatorColor = Color.Cyan,
                unfocusedIndicatorColor = Color.Cyan,
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        )

        Button(onClick = {
            authViewModel.login(email = Email, password = Password)
        },
            colors = ButtonDefaults.buttonColors(Color.Cyan),
            modifier = Modifier.padding(top = 14.dp)

        ) {
            Text(text = "Login")
        }

        TextButton(onClick = {
            navController.navigate("signup")
        }){
            Text(text  = "Dont have any account ? SignUp" )
        }
            
    }
}

//@Preview
//@Composable
//private fun previewLoginPage() {
//    LoginPage(navController = NavController , authViewModel = AuthViewModel())
//}
