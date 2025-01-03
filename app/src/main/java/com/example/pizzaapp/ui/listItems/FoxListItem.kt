package com.example.pizzaapp.ui.listItems

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.pizzaapp.ui.theme.Black
import com.example.pizzaapp.ui.theme.ButtonGray
import com.example.pizzaapp.ui.theme.Grey
import com.example.pizzaapp.ui.theme.HelveticaFontFamily
import com.example.pizzaapp.ui.theme.MalinaFontFamily
import com.example.pizzaapp.ui.theme.Orange
import com.example.pizzaapp.ui.theme.White
import com.example.pizzaapp.util.ListItem

@Composable
fun FoxListItem(
    item: ListItem
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardColors(
            containerColor = White,
            contentColor = White,
            disabledContainerColor = White,
            disabledContentColor = White,
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(start = 10.dp, end = 10.dp, bottom = 0.dp, top = 10.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = item.imageName),
                        contentScale = ContentScale.Fit,
                        contentDescription = "Pizza image",
                        modifier = Modifier
                            .width(140.dp)
                            .height(61.dp)
                    )
                    Image(
                        painter = rememberAsyncImagePainter(model = item.imageName),
                        contentScale = ContentScale.Fit,
                        contentDescription = "Pizza image",
                        modifier = Modifier
                            .width(140.dp)
                            .height(61.dp)
                            .rotate(180F)
                    )
                }
                Column {
                    Text(
                        text = item.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Orange,
                        fontFamily = MalinaFontFamily,
                        modifier = Modifier.padding(top = 5.dp, start = 10.dp),
                        lineHeight = TextUnit(18.0F, TextUnitType.Sp)
                    )
                    Text(
                        text = item.ingredients,
                        fontSize = 14.sp,
                        color = Grey,
                        fontFamily = HelveticaFontFamily,
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                        textAlign = TextAlign.Justify,
                        lineHeight = TextUnit(14.0F, TextUnitType.Sp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "от ${item.price} руб.",
                    fontSize = 20.sp,
                    color = Black,
                    fontFamily = MalinaFontFamily,
                    modifier = Modifier.padding(end = 20.dp),
                )
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
                        context.startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonColors(
                        containerColor = ButtonGray,
                        contentColor = Orange,
                        disabledContainerColor = ButtonGray,
                        disabledContentColor = Orange
                    )
                ) {
                    Text(
                        "Заказать",
                        fontSize = 20.sp,
                        fontFamily = MalinaFontFamily,
                        modifier = Modifier.padding(0.dp)
                    )
                }
            }
        }
    }
}
