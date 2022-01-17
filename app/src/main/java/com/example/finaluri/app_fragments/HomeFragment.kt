package com.example.finaluri.app_fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finaluri.Book
import com.example.finaluri.R
import com.example.finaluri.RecyclerViewAdapter
import java.util.ArrayList


class HomeFragment:Fragment(R.layout.fragment_home) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerViewAdapter = RecyclerViewAdapter(getData())
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recyclerViewAdapter

    }



    private fun getData(): List<Book> {

        val list = ArrayList<Book>()

        list.add(
            Book(
                1,
                "https://images-na.ssl-images-amazon.com/images/I/91Mtm99CnaL.jpg",
                "შერლოკ ჰოლმსი",
                "საუკეთესო არჩევანია დეტექტივების მოყვარულთათვის, შერლოკ ჰოლმსი მკითხველში ნამდვილად გამოიწვევს აღფრთოვანებას",
                "https://eon.ge/book/შერლოკ-ჰოლმსის-თავგადასა/"

            )
        )
        list.add(
            Book(
                2,
                "https://images-na.ssl-images-amazon.com/images/I/71Yl9WYd4+S.jpg",
                "დორიან გრეის პორტრეტი",
                "საუკეთესო არჩევანია ფილოსოფიური რომანების მოყვარულთათვის,მასში ასახულია ოსკარ უაილდის მსოფლმხედველობა და დამოკიდებულება სილამაზის...",
                "https://eon.ge/book/დორიან-გრეის-პორტრეტი/"
            )
        )

        list.add(
            Book(
                3,
                "https://bookland.ge/images/virtuemart/product/eshmakni2.jpg",
                "ეშმაკნი",
                "ეშმაკნი“ დოსტოევსკის ერთ-ერთი ყველაზე პოლიტიზებული, რთული, წინააღმდეგობრივი, პოლიფონიური რომანია,თავის ჟანრში ერთ-ერთი საუკეთესოა",
                "https://eon.ge/book/ეშმაკნი/"
            )
        )

        list.add(
            Book(
                4,
                "https://saba.com.ge/content/images/book/o/c477633ea4b54faaaa50308c1c993505.png",
                "იდიოტი",
                "თეოდორ დოსტოევსკი ის ავტორია, რომელის გარეშეც არ არსებობს მსოფლიო ლიტერატურა, მისი ეს წიგნი კი უბრალოდ გენიალურია",
                "https://eon.ge/book/იდიოტი/"
            )
        )
        list.add(
            Book(
                5,
                "https://images-na.ssl-images-amazon.com/images/I/91SZSW8qSsL.jpg",
                "1984",
                "ჯორჯო ორუელი ანტიუტოპიური რომანია, რომელიც აღწერს ტოტალიტარული რეჟიმის ყოფას.",
                "https://eon.ge/book/1984/"
            )
        )
        list.add(
            Book(
                6,
                "https://www.bookland.ge/images/virtuemart/product/dostoevski-danashauli-da-sasjeli.jpg",
                "დანაშაული და სასჯელი",
                "თეოდორ დოსტოევსკი ის ავტორია, რომელის გარეშეც არ არსებობს მსოფლიო ლიტერატურა, მისი ეს წიგნი კი უბრალოდ გენიალურია",
                "https://eon.ge/book/დანაშაული-და-სასჯელი/"
            )
        )

        list.add(
            Book(
                7,
                "https://image.api.playstation.com/cdn/EP4062/CUSA00591_00/o0nw1XsrxYS4wuug9cTqPFqPhRinf2zd.png",
                "მეტრო 2033",
                "დიმიტრი გლუხოვსკის პოსტაპოკალიფსური რომანი,მასში აღწერილია ადამიანების ცხოვრება მეტროში ბირთვული ომის შემდეგ",
                "https://eon.ge/book/მეტრო-2033-metro-1/"
            )
        )

        list.add(
            Book(
                8,
                "https://upload.wikimedia.org/wikipedia/en/6/62/Silence3.png",
                "კრავთა დუმილი",
                "კრავთა დუმილი“ რომანი-გამოცანაა. აქ ერთმანეთს უპირისპირდებიან გამოძიების ფედერალური ბიუროს აკადემიის სტუდენტი კლარის სტარლინგი...",
                "https://pdfcookie.com/documents/pdfcookie-8v449j3998vg"
            )
        )
        list.add(
            Book(
                9,
                "https://images-na.ssl-images-amazon.com/images/I/91Mtm99CnaL.jpg",
                "შერლოკ ჰოლმსი",
                "საუკეთესო არჩევანია დეტექტივების მოყვარულთათვის, შერლოკ ჰოლმსი მკითხველში ნამდვილად გამოიწვევს აღფრთოვანებას",
                "https://eon.ge/book/შერლოკ-ჰოლმსის-თავგადასა/"
            )
        )
        list.add(
            Book(
                10,
                "https://images-na.ssl-images-amazon.com/images/I/71Yl9WYd4+S.jpg",
                "დორიან გრეის პორტრეტი",
                "საუკეთესო არჩევანია ფილოსოფიური რომანების მოყვარულთათვის,მასში ასახულია ოსკარ უაილდის მსოფლმხედველობა და დამოკიდებულება სილამაზის...",
                "https://eon.ge/book/დორიან-გრეის-პორტრეტი/"

            )
        )

        list.add(
            Book(
                11,
                "https://bookland.ge/images/virtuemart/product/eshmakni2.jpg",
                "ეშმაკნი",
                "ეშმაკნი“ დოსტოევსკის ერთ-ერთი ყველაზე პოლიტიზებული, რთული, წინააღმდეგობრივი, პოლიფონიური რომანია,თავის ჟანრში ერთ-ერთი საუკეთესოა",
                "https://eon.ge/book/ეშმაკნი/"
            )
        )

        list.add(
            Book(
                12,
                "https://saba.com.ge/content/images/book/o/c477633ea4b54faaaa50308c1c993505.png",
                "იდიოტი",
                "თეოდორ დოსტოევსკი ის ავტორია, რომელის გარეშეც არ არსებობს მსოფლიო ლიტერატურა, მისი ეს წიგნი კი უბრალოდ გენიალურია",
                "https://eon.ge/book/იდიოტი/"
            )
        )
        list.add(
            Book(
                13,
                "https://images-na.ssl-images-amazon.com/images/I/91SZSW8qSsL.jpg",
                "1984",
                "ჯორჯო ორუელი ანტიუტოპიური რომანია, რომელიც აღწერს ტოტალიტარული რეჟიმის ყოფას.",
                "https://eon.ge/book/1984/"

            )
        )
        list.add(
            Book(
                14,
                "https://www.bookland.ge/images/virtuemart/product/dostoevski-danashauli-da-sasjeli.jpg",
                "დანაშაული და სასჯელი",
                "თეოდორ დოსტოევსკი ის ავტორია, რომელის გარეშეც არ არსებობს მსოფლიო ლიტერატურა, მისი ეს წიგნი კი უბრალოდ გენიალურია",
                "https://eon.ge/book/დანაშაული-და-სასჯელი/"
            )
        )

        list.add(
            Book(
                15,
                "https://image.api.playstation.com/cdn/EP4062/CUSA00591_00/o0nw1XsrxYS4wuug9cTqPFqPhRinf2zd.png",
                "მეტრო 2033",
                "დიმიტრი გლუხოვსკის პოსტაპოკალიფსური რომანი,მასში აღწერილია ადამიანების ცხოვრება მეტროში ბირთვული ომის შემდეგ",
                "https://eon.ge/book/მეტრო-2033-metro-1/"

            )
        )

        list.add(
            Book(
                16,
                "https://upload.wikimedia.org/wikipedia/en/6/62/Silence3.png",
                "კრავთა დუმილი",
                "კრავთა დუმილი“ რომანი-გამოცანაა. აქ ერთმანეთს უპირისპირდებიან გამოძიების ფედერალური ბიუროს აკადემიის სტუდენტი კლარის სტარლინგი...",
                "https://pdfcookie.com/documents/pdfcookie-8v449j3998vg"
            )
        )



        return list

    }
}


