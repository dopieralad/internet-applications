import React, {Component} from "react";
import Card from "@material-ui/core/Card";
import CardActions from "@material-ui/core/CardActions";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import {withStyles} from "@material-ui/core/styles";
import Avatar from "@material-ui/core/Avatar";
import LockIcon from "@material-ui/icons/Lock";

const styles = (theme) => ({
    main: {
        display: "flex",
        flexDirection: "column",
        minHeight: "100vh",
        alignItems: "center",
        justifyContent: "flex-start",
        background: "url(https://source.unsplash.com/collection/1895329/1600x900)",
        backgroundRepeat: "no-repeat",
        backgroundSize: "cover"
    },
    card: {
        minWidth: 300,
        marginTop: "6em"
    },
    avatar: {
        margin: "1em",
        display: "flex",
        justifyContent: "center"
    },
    icon: {
        backgroundColor: theme.palette.secondary.main
    },
    form: {
        padding: "0 1em 1em 1em"
    },
    input: {
        marginTop: "1em"
    },
    actions: {
        padding: "0 1em 1em 1em"
    }
});

class LoginPage extends Component {
    render() {
        const {classes} = this.props;

        return (
            <div className={classes.main}>
                <Card className={classes.card}>
                    <div className={classes.avatar}>
                        <Avatar className={classes.icon}>
                            <LockIcon/>
                        </Avatar>
                    </div>
                    <form>
                        <div className={classes.form}>
                            <div className={classes.input}>
                                <TextField fullWidth/>
                            </div>
                            <div className={classes.input}>
                                <TextField type="password" fullWidth/>
                            </div>
                        </div>
                        <CardActions className={classes.actions}>
                            <Button
                                variant="contained"
                                type="submit"
                                color="primary"
                                className={classes.button}
                                fullWidth
                            >
                                Zaloguj się
                            </Button>
                        </CardActions>
                    </form>
                </Card>
            </div>
        );
    }
}

export default withStyles(styles)(LoginPage);
