package com.agesadev.codewarstwo.presentation.screens.challengedetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agesadev.codewarstwo.R
import com.agesadev.codewarstwo.util.TestTags.CARD_DETAIL_SCREEN_ITEM

@Composable
fun CardItem(value: Int, content: String, imageResource: Int) {

    val resId = R.drawable.ic_star
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .testTag(CARD_DETAIL_SCREEN_ITEM),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            Image(
                painterResource(imageResource),
                contentDescription = resId.toString(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(30.dp)
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = value.toString(),
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = content,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 8.sp
            )

        }

    }
}


@Preview(showBackground = true)
@Composable
fun CardItemPreview() {
    CardItem(12, content = "Stars", R.drawable.ic_star)
}